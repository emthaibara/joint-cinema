package scbc.liyongjie.nettywebsocketserver.controller;

import org.springframework.web.bind.annotation.*;
import scbc.liyongjie.nettywebsocketserver.pojo.ShareVideoPoJo;
import scbc.liyongjie.nettywebsocketserver.result.Result;
import scbc.liyongjie.nettywebsocketserver.service.ShareVideoService;
import scbc.liyongjie.nettywebsocketserver.service.VideoShareLaunchService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 *
 */

@RestController
public class VideoShareController {

    @Resource
    private VideoShareLaunchService videoShareLaunchService;

    @Resource
    private ShareVideoService shareVideoService;

    @PutMapping("/video/share/launch/send")
    public Result<String> videoShareLaunch(@RequestParam(value = "number")String number,
                                           @RequestParam(value = "username")String username,
                                           @RequestParam(value = "receiver")String receiver,
                                           @RequestParam(value = "shareVideoUUID")String shareVideoUrl,
                                           @RequestParam(value = "shareVideoName") String shareVideoName){
        videoShareLaunchService.videoShareLaunchHandle(number,username,receiver,shareVideoUrl,shareVideoName);
        return new Result<>("vide share launch success!");
    }

//    @PutMapping("/video/share/")
//    public Result<String> videoShare(@RequestParam(value = "number")String shareSender,
//                                     @RequestParam(value = "provider_number")String providerNumber,
//                                     @RequestParam(value = "videoUUID")String videoUUID){
//        shareVideoService.doShare(shareSender,providerNumber,videoUUID);
//        return new Result<>("video share bind success!");
//    }
//
//    @GetMapping("/get/friend/share/videoList")
//    public Result<List<ShareVideoPoJo>> getFriendShareVideoList(@RequestParam(value = "number")String number){
//        List<ShareVideoPoJo> shareVideoPoJoList = shareVideoService.getShareVideo(number);
//        return new Result<>(null);
//    }




}
