package cn.scbc.servicevideouploadapi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/14
 */


public class FilesUtils {

    private static final Logger log = LoggerFactory.getLogger(FilesUtils.class);

    public static Path creatFile(String path){
        Path target = Paths.get(path);
        try {
            if(!Files.exists(target))
                return Files.createFile(target);
        } catch (IOException e) {
            log.error("文件创建失败："+e.getMessage());
        }
        return null;
    }

    public static Path creatFolder(String path){
        Path target = Paths.get(path);
        try {
            return Files.createDirectory(target);
        } catch(FileAlreadyExistsException e){
            return null;
        } catch (IOException e) {
            log.error("io 异常:"+e.getMessage());
        }
        return null;
    }

    public static void remove(String path){
        Path target = Paths.get(path);
        try {
            Files.delete(target);
        } catch (IOException e) {
            log.error("remove error:"+e.getMessage());
        }
    }

}
