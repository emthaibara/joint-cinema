package scbc.liyongjie.servicevideoapi.controller;

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

    @Resource
    private VideoService videoService;

    @Resource
    private ShareVideoService shareVideoService;

    @GetMapping("/get/video/")
    public Result<List<Video>> getPrivateVideoList(@RequestParam(value = "number")String number){
        List<Video> videoList= videoService.getPrivateStoreHouseVideoList(number);
        return new Result<>(videoList);
    }

    @DeleteMapping("/delete/video/")
    public Result<String> deleteVideo(@RequestParam(value = "number")String number,
                                      @RequestParam(value = "videoUUID")String videoUUID){
        videoService.deleteVideo(number,videoUUID);
        return new Result<>("video delete success");
    }

    @GetMapping("/get/friend/share/videoList/")
    public Result<List<ShareVideoPoJo>> getFriendShareVideoList(@RequestParam(value = "number")String number){
        List<ShareVideoPoJo> shareVideoPoJoList = shareVideoService.getShareVideo(number);
        return new Result<>(shareVideoPoJoList);
    }

    @DeleteMapping("/share/video/unbind/")
    public Result<String> unBind(@RequestParam(value = "number")String number,
                                 @RequestParam(value = "provider_number")String providerNumber,
                                 @RequestParam(value = "videoUUID")String videoUUID){
        shareVideoService.unBind(number,providerNumber,videoUUID);
        return new Result<>("解除分享成功!");
    }

    @PutMapping("/video/share/")
    public Result<String> videoShare(@RequestParam(value = "number")String number,
                                     @RequestParam(value = "provider_number")String providerNumber,
                                     @RequestParam(value = "videoUUID")String videoUUID){
        shareVideoService.doShare(number,providerNumber,videoUUID);
        return new Result<>("video share bind success!");
    }

}

