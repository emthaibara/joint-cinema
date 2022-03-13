package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.exception.BuildChunkFileException;
import cn.scbc.servicevideouploadapi.exception.ChunkUploadException;
import cn.scbc.servicevideouploadapi.pojo.ChunkPoJo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 *
 */

@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class ChunkUploadService {

    private final Logger log = LoggerFactory.getLogger(ChunkUploadService.class);

    @Value("${upload.storePath}")
    private String storePath;

    /**
     * 分片上传整个流程:
     *      创建File ----> chunk文件 以序号作文文件名
     *      rootPath/storeHouseUUID/md5/ChunkIndex(0-n)
     * @param chunkPoJo chunkPoJo
     */
    public void chunkUpload(ChunkPoJo chunkPoJo,String storeHouseUUID){
        MultipartFile multipartFile = chunkPoJo.getFile();
        Integer chunkIndex = chunkPoJo.getChunk();
        chunkIndex = Objects.isNull(chunkIndex) ? 0 : chunkIndex ; //有些较小文件传输上来可能就一个文件，不足5-10mb，默认chunkIndex为null
        //在妙传判断的时候初始化分片临时文件夹----md5作为文件夹名
        String chunkPath = BuildPathUtils.buildPath(storePath,storeHouseUUID,"/",chunkPoJo.getMd5(),"/",chunkIndex.toString());
        File file = new File(chunkPath);
        //避免重复上传分片
        if (file.exists())
            return;
        //创建分片文件---用于存储原始二进制数据
        if (!file.mkdir()){
            log.error("分片---{}---临时分片文件创建失败！！",chunkIndex);
            throw new BuildChunkFileException();
        }

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error("分片---{}---上传失败！！请重传该分片-------error message:{}",chunkIndex,e.getMessage());
            throw new ChunkUploadException();
        }

    }
}
