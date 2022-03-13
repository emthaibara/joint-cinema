package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.result.Result;
import cn.scbc.servicevideouploadapi.service.MergeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

@RestController
public class MergeController {

    @Resource
    private MergeService mergeService;

    @PostMapping("/mergeChunk/{storeHouseUUID}")
    public Result<String> mergeChunk(MergeChunkPoJo mergeChunkPoJo,
                                     @PathVariable String storeHouseUUID) {
        //异步执行----执行结果通过netty搭建的websocket服务器通知用户(有机会试一试消息队列)
        mergeService.merge(mergeChunkPoJo,storeHouseUUID);
        return Result.mergeChunkSuccess();
    }

}
