package scbc.liyongjie.servicevideoapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import scbc.liyongjie.servicevideoapi.po.Video;
import scbc.liyongjie.servicevideoapi.pojo.ShareVideoPoJo;
import scbc.liyongjie.servicevideoapi.result.Result;
import scbc.liyongjie.servicevideoapi.service.ShareVideoService;
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

    @Resource
    private ShareVideoService shareVideoService;

    //todo
    @GetMapping("/get/video/")
    public Result<List<Video>> getPrivateVideoList(@RequestParam(value = "number")String number){
        List<Video> videoList= videoService.getPrivateStoreHouseVideoList(number);
        log.info(videoList.toString());
        return new Result<>(videoList);
    }

    @DeleteMapping("/delete/video/")
    public Result<String> deleteVideo(@RequestParam(value = "number")String number,
                                      @RequestParam(value = "videoUUID")String videoUUID){
        return new Result<>();
    }

    //todo
    @GetMapping("/get/friend/share/videoList/")
    public Result<List<ShareVideoPoJo>> getFriendShareVideoList(@RequestParam(value = "number")String number){
        List<ShareVideoPoJo> shareVideoPoJoList = shareVideoService.getShareVideo(number);
        return new Result<>(shareVideoPoJoList);
    }

    @DeleteMapping("/share/video/unbind/")
    public Result<String> unBind(@RequestParam(value = "number")String number,
                                 @RequestParam(value = "provider_number")String providerNumber,
                                 @RequestParam(value = "videoUUID")String videoUUID){

        return new Result<>();
    }

    //todo
    @PutMapping("/video/share/")
    public Result<String> videoShare(@RequestParam(value = "number")String number,
                                     @RequestParam(value = "provider_number")String providerNumber,
                                     @RequestParam(value = "videoUUID")String videoUUID){
        shareVideoService.doShare(number,providerNumber,videoUUID);
        return new Result<>("video share bind success!");
    }

}

