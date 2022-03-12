package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.ChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.result.Result;
import cn.scbc.servicevideouploadapi.service.ChunkUploadService;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 *
 */
@RestController
@CrossOrigin
public class UploadController {

    @Resource
    private ChunkUploadService uploadService;

    @PostMapping("/isSecondPass/{storeHouseUUID}")
    public Result<Boolean> isSecondPass(SecondPassPoJo secondPassPoJo,
                                        @PathVariable String storeHouseUUID){
        //Boolean result = secondPassService.isSecondPass(secondPassPoJo.getFileMd5());
        return new Result<>(Boolean.FALSE);
    }

    @PostMapping("/mergeChunk/{storeHouseUUID}")
    public Result<String> mergeChunk(MergeChunkPoJo mergeChunkPoJo,
                                     @PathVariable String storeHouseUUID) {
        return Result.mergeChunkSuccess();
    }

    @PostMapping("/upload/chunk/{storeHouseUUID}")
    public String uploadChunk(ChunkPoJo chunkPoJo,
                              @PathVariable String storeHouseUUID)  {
        uploadService.chunkUpload(chunkPoJo,storeHouseUUID);
        return "ok";
    }

}
