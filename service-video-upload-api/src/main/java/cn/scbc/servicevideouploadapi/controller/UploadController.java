package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.ChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.result.Result;
import cn.scbc.servicevideouploadapi.service.SecondPassService;
import cn.scbc.servicevideouploadapi.service.UploadService;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */
@RestController
@CrossOrigin
public class UploadController {

    private final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Resource
    private UploadService uploadService;

    @Resource
    private SecondPassService secondPassService;

    @PostMapping("/isSecondPass")
    public Result<?> isSecondPass(SecondPassPoJo secondPassPoJo){
        //Boolean result = secondPassService.isSecondPass(secondPassPoJo.getFileMd5());
        return new Result<>(Boolean.FALSE);
    }

    @PostMapping("/doSecondPass")
    public Result<?> secondPass(){
        return new Result<>("second pass success!");
    }

    @PostMapping("/mergeChunk")
    public Result<?> mergeChunk(MergeChunkPoJo mergeChunkPoJo) {
        uploadService.doMerge(mergeChunkPoJo);
        return Result.mergeChunkSuccess();
    }

    @PostMapping("/upload/chunk")
    public String uploadChunk(ChunkPoJo chunkPoJo)  {
        uploadService.chunkUpload(chunkPoJo);
        return "ok";
    }

}