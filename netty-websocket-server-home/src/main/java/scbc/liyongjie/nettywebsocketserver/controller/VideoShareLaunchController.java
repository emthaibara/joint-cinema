package scbc.liyongjie.nettywebsocketserver.controller;

import org.springframework.web.bind.annotation.*;
import scbc.liyongjie.nettywebsocketserver.message.VideoShareLaunchMessage;
import scbc.liyongjie.nettywebsocketserver.result.Result;
import scbc.liyongjie.nettywebsocketserver.service.VideoShareLaunchService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 *
 */

@RestController
public class VideoShareLaunchController {

    @Resource
    private VideoShareLaunchService videoShareLaunchService;

    @PutMapping("/video/share/launch/send")
    public Result<String> videoShareLaunch(@RequestParam(value = "sender_number")String senderNumber,
                                           @RequestParam(value = "sender_nickname")String senderNickname,
                                           @RequestParam(value = "sender_avatar")String senderAvatar,
                                           @RequestParam(value = "receiver")String receiver,
                                           @RequestParam(value = "shareVideoUUID")String shareVideoUUID,
                                           @RequestParam(value = "shareVideo")String shareVideo,
                                           @RequestParam(value = "shareVideoName") String shareVideoName){
        videoShareLaunchService.videoShareLaunchHandle(senderNumber,senderNickname,senderAvatar,receiver,shareVideoUUID,shareVideo,shareVideoName);
        return new Result<>("vide share launch success!");
    }

    @GetMapping("/get/video/share/launch/cache/")
    public Result<List<VideoShareLaunchMessage>> getVideoShareLaunchMessageCache(@RequestParam(value = "number")String number){
        List<VideoShareLaunchMessage> videoShareLaunchMessageList = videoShareLaunchService.getVideoShareLaunchMessageCache(number);
        return new Result<>(null);
    }
}
