package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class MergeService {

    @Value("${upload.storePath}")
    private String storePath;

    @Async
    public void merge(MergeChunkPoJo mergeChunkPoJo,String storeHouseUUID){

    }

}
