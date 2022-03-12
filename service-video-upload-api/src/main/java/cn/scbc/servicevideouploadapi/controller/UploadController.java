package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.ChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.result.Result;
import cn.scbc.servicevideouploadapi.service.UploadService;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */
@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;

    @PostMapping("/isSecondPass")
    public Result<Boolean> isSecondPass(SecondPassPoJo secondPassPoJo){
        //Boolean result = secondPassService.isSecondPass(secondPassPoJo.getFileMd5());
        return new Result<>(Boolean.FALSE);
    }

//    @PostMapping("/mergeChunk")
//    public Result<String> mergeChunk(MergeChunkPoJo mergeChunkPoJo) {
//        uploadService.doMerge(mergeChunkPoJo);
//        return Result.mergeChunkSuccess();
//    }

    @PostMapping("/upload/chunk")
    public String uploadChunk(ChunkPoJo chunkPoJo)  {
        uploadService.chunkUpload(chunkPoJo);
        return "ok";
    }

}
