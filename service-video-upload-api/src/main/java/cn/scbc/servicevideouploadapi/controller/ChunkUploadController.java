package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.ChunkPoJo;
import cn.scbc.servicevideouploadapi.service.ChunkUploadService;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 *
 */

@RestController
public class ChunkUploadController {

    @Resource
    private ChunkUploadService uploadService;

    @PostMapping("/upload/chunk/{storeHouseUUID}")
    public String uploadChunk(ChunkPoJo chunkPoJo,
                              @PathVariable String storeHouseUUID)  {
        uploadService.chunkUpload(chunkPoJo,storeHouseUUID);
        return "ok";
    }

}
