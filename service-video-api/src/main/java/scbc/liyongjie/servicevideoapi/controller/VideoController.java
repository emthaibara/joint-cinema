package scbc.liyongjie.servicevideoapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicevideoapi.po.Video;
import scbc.liyongjie.servicevideoapi.result.Result;
import scbc.liyongjie.servicevideoapi.service.VideoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/17
 */

@RestController
public class VideoController {

    private static final Logger log = LoggerFactory.getLogger(VideoController.class);

    @Resource
    private VideoService videoService;

    @GetMapping("/get/video/")
    public Result<List<Video>> getPrivateVideoList(@RequestParam(value = "number")String number){
        List<Video> videoList= videoService.getPrivateStoreHouseVideoList(number);
        log.info(videoList.toString());
        return new Result<>(videoList);
    }

    /**
     * 删除上传等操作暂不提供
     */
}

