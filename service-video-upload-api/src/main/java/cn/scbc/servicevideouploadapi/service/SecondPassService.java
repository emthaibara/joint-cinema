package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.dao.VideoMapper;
import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import cn.scbc.servicevideouploadapi.utils.FilesUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/2/18
 *
 */
@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class SecondPassService {

    @Value("${upload.storePath}")
    private String storePath;

    @Resource
    private VideoMapper videoMapper;

    public Boolean isSecondPass(String storeHouseUUID, SecondPassPoJo secondPassPoJo){
        String md5 = secondPassPoJo.getFileMd5();
        String path = BuildPathUtils.buildPath(storePath,storeHouseUUID,"/",md5);
        Path chunkFolder = Paths.get(path);

        //去数据库看有没有对应md5值的视频
        if (!videoMapper.selectByMd5(md5).isEmpty())
            return Boolean.TRUE;

        //然后再看看有没有没上传完或者没合并的视频切片文件夹，如果存在则按照不秒传的规则，如果不存在则新建md5为名字的分片文件夹
        if (Files.exists(chunkFolder))
            return Boolean.FALSE;

        FilesUtils.creatFolder(path);
        return Boolean.FALSE;
    }

}
