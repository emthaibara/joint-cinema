package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.dao.VideoMapper;
import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import cn.scbc.servicevideouploadapi.utils.FilesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(SecondPassService.class);

    @Value("${upload.storePath}")
    private String storePath;

    @Resource
    private VideoMapper videoMapper;


    /**
     *分片上传前的妙传检查：
     *          1.业务1--->
     *                  i.根据md5查看私人仓库文件夹是否存在md5+type的待传输视频文件
     *                  ii.如果存在则返回FALSE<----->结果为不需要妙传
     *                  iii.如果不存在则进一步判断数据库中是否存以md5对应的视频记录
     *                  iv.
     * @param storeHouseUUID    仓库UUID
     * @param secondPassPoJo    妙传实体
     * @return  返回是否妙传的判断
     */
    public Boolean isSecondPass(String storeHouseUUID, SecondPassPoJo secondPassPoJo){
        String md5 = secondPassPoJo.getFileMd5();
        String path = BuildPathUtils.buildPath(storePath,storeHouseUUID,"/",md5);

        Path chunkFolder = Paths.get(path);

        //去数据库看有没有对应md5值的视频
        if (!videoMapper.selectByMd5(md5).isEmpty())
            return Boolean.TRUE;

        //然后再看看有没有没上传完的带传输数据的视频文件，如果存在则按照不秒传的规则，如果不存在则新建md5为名字的待传输数据的视频文件
        if (Files.exists(chunkFolder))
            return Boolean.FALSE;

        FilesUtils.creatFolder(path);
        return Boolean.FALSE;
    }

}
