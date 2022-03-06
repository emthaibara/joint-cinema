package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.exception.BasicException;
import cn.scbc.servicevideouploadapi.pojo.ChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class UploadService {

    private final Logger logger = LoggerFactory.getLogger(UploadService.class);

    @Value("${upload.storePath}")
    private String storePath;

    public void chunkUpload(ChunkPoJo chunkPoJo){

        MultipartFile multipartFile = chunkPoJo.getFile();

        Integer chunk = chunkPoJo.getChunk();
        chunk = Objects.isNull(chunk) ? 0 : chunk ;

        String md5 = chunkPoJo.getMd5();

        File file = new File(storePath + "/" + md5);

        if (!file.exists()) {
            Boolean mkdir = file.mkdir();
        }

        File chunkFile = new File(storePath + md5 + "/" + chunk);

        try {
            multipartFile.transferTo(chunkFile);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }

    }

    public void doMerge(MergeChunkPoJo mergeChunkPoJo){

        String md5 = mergeChunkPoJo.getFileMd5();
        String fileName = mergeChunkPoJo.getFileName();

        File folder = new File(storePath+md5);
        if (!folder.exists())
            throw  new BasicException("file not exist !");

        File[] files = folder.listFiles();

        if (Objects.isNull(files))
            throw new BasicException("你似乎还没上传该视频，合并失败！！");

        int size = files.length;

        File merge = new File(storePath+fileName);
        BufferedOutputStream outputStream = null;       //带缓冲区的输出流效率会高很多

        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(merge));
            logger.info("分片上传成功！ 正在合并中......");

            for (int k = 0; k < size ; k++){
                outputStream.write(new FileInputStream(storePath+md5+"/"+k).readAllBytes());
            }

            FileUtils.deleteDirectory(folder);
        } catch (IOException e) {
            logger.error(e.getMessage());
                throw new BasicException(e.getMessage());
        }finally {
            try {
                if (!Objects.isNull(outputStream)) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        logger.info("mergeChunk success !"+folder.delete());
    }

}