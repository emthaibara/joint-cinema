package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.dao.VideoMapper;
import cn.scbc.servicevideouploadapi.exception.BuildChunkFolderException;
import cn.scbc.servicevideouploadapi.grpc.FFmpegServiceConsumerGrpc;
import cn.scbc.servicevideouploadapi.po.Video;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import cn.scbc.servicevideouploadapi.utils.FilesUtils;
import cn.scbc.servicevideouploadapi.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */
@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class FFmpegService {

    private static final Logger log = LoggerFactory.getLogger(FFmpegService.class);

    @Resource
    private FFmpegServiceConsumerGrpc fFmpegServiceConsumerGrpc;

    @Resource
    private SimpleDateFormat simpleDateFormat;

    @Value("${upload.storePath}")
    private String storePath;

    @Resource
    private VideoMapper videoMapper;

    public void ffmpegServiceAdvice(MergeChunkPoJo mergeChunkPoJo,String soreHouseUUID){
        String videoName = mergeChunkPoJo.getFileName();
        String videoType = mergeChunkPoJo.getFileType();

        //视频源文件
        String originPath = BuildPathUtils.buildPath(storePath,soreHouseUUID,"/",mergeChunkPoJo.getFileMd5(),videoType);
        String videoDash_Chunk_mpd_Folder_UUID = UUIDUtils.getUUID();

        //存储dash流的文件夹path
        String mpdFolderPath = BuildPathUtils.buildPath(storePath,soreHouseUUID,"/",videoDash_Chunk_mpd_Folder_UUID,"/");

        Path mpdFolder = FilesUtils.creatFolder(mpdFolderPath);

        if (Objects.isNull(mpdFolder))
            throw new BuildChunkFolderException();

        String buildDashPath = BuildPathUtils.buildPath(mpdFolderPath,videoDash_Chunk_mpd_Folder_UUID,".mpd");
        String buildThumbnailPath = BuildPathUtils.buildPath(mpdFolderPath,videoDash_Chunk_mpd_Folder_UUID,".jpeg");


        log.info("origin--{}---targetPath---{}",originPath,buildDashPath);
        // 缩略图+dash流-----异步执行
        fFmpegServiceConsumerGrpc.buildDashGrpc(originPath,buildDashPath);
        fFmpegServiceConsumerGrpc.buildThumbnailGrpc(originPath,buildThumbnailPath);

        //最后将 相关数据存储数据库
        Video video = new Video();
        video.setDate(simpleDateFormat.format(new Date()));
        video.setDuration("HH:MM");
        video.setMd5(mergeChunkPoJo.getFileMd5());
        video.setSize(mergeChunkPoJo.getFileSize());
        video.setStorehouse(soreHouseUUID);
        video.setThumbnail(buildThumbnailPath);
        video.setType(mergeChunkPoJo.getFileType());
        video.setUrl(buildDashPath);
        video.setUuid(videoDash_Chunk_mpd_Folder_UUID);
        video.setName(videoName);
        videoMapper.insert(video);
        log.info("有新的视频上传-------{}", video);

    }

}
