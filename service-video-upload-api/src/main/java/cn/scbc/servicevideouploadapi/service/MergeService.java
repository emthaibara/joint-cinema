package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.exception.BuildChunkFolderException;
import cn.scbc.servicevideouploadapi.exception.StoreHouseNotExistsException;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import cn.scbc.servicevideouploadapi.utils.FilesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

@EnableAsync
@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class MergeService {

    private static final Logger log = LoggerFactory.getLogger(MergeService.class);

    @Value("${upload.storePath}")
    private String storePath;

    @Resource
    private FFmpegService fFmpegService;

    /**
     * 合并分片：
     *
     * @param mergeChunkPoJo    合并请求数据实体
     * @param storeHouseUUID    仓库UUID
     */
    @Async
    public void merge(MergeChunkPoJo mergeChunkPoJo,String storeHouseUUID){
        String storeHousePath = BuildPathUtils.buildPath(storePath,storeHouseUUID,"/");
        String md5 = mergeChunkPoJo.getFileMd5();
        String chunkFolderPath = BuildPathUtils.buildPath(storeHousePath,md5,"/");

        File chunkFolder = new File(chunkFolderPath);   //分片文件夹

        if (!chunkFolder.exists()){
            log.error("不存在此分片文件夹-----{}",chunkFolderPath);
            throw new BuildChunkFolderException();
        }

        File[] chunks = chunkFolder.listFiles();
        if (Objects.isNull(chunks) || chunks.length == 0){
            //此处应该grpc 调用netty - websocket通知用户分片合并失败
            log.error("仓库---{}---正在合并的视频---{}---合并失败---原因：分片不存在，可能上传中断导致",storeHouseUUID,mergeChunkPoJo.getFileMd5());
            throw new BuildChunkFolderException();
        }

        //构建视频文件，md5作为视频名，视频原名存储数据库

        String type = mergeChunkPoJo.getFileType();
        String videoPath = BuildPathUtils.buildPath(storeHousePath,md5,type);

        Path videoFile = FilesUtils.creatFile(videoPath);

        if (Objects.isNull(videoFile)) {
            log.error("仓库----{}---正在构建的视频文件---{}---构建失败---原因：仓库被删除，可能被管理员拉黑...",storeHouseUUID,mergeChunkPoJo.getFileMd5());
            throw new StoreHouseNotExistsException();
        }

        //分片的总个数
        Integer total = chunks.length;

        doMerge(videoFile,total,chunkFolderPath);

        //删除分片文件夹
        FilesUtils.remove(chunkFolderPath);

        fFmpegService.ffmpegServiceAdvice(mergeChunkPoJo,storeHouseUUID);
    }


    /**
     * 合并分片：
     *      实际上是往视频文件内追加分片数据，不断重复的读写，读分片的数据，写入视频文件
     *      利用mmap优化频繁的读写
     * @param outPutFile    待写入数据的视频文件
     * @param total 分片总数
     * @param chunkFolderPath   分片文件夹路径
     * @Param fileSize  视频文件大小---byte单位
     *
     */
    public void doMerge(Path outPutFile,Integer total,String chunkFolderPath){
        try (FileChannel outputChannel = FileChannel.open(outPutFile,
                EnumSet.of(StandardOpenOption.WRITE))){
            for (int i = 0; i < total; i++) {
                String chunkPath = BuildPathUtils.buildPath(chunkFolderPath,String.valueOf(i));
                FileChannel chunkFileChannel = FileChannel.open(Path.of(chunkPath), EnumSet.of(StandardOpenOption.READ));
                chunkFileChannel.transferTo(0,chunkFileChannel.size(),outputChannel);
                //传输完成后删除分片
                FilesUtils.remove(chunkPath);
            }
        } catch (IOException e) {
            log.error("文件合并异常------切片来自-----{}",chunkFolderPath);
        }
    }

}
