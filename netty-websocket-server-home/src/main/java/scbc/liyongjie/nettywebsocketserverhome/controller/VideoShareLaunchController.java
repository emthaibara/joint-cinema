package scbc.liyongjie.nettywebsocketserverhome.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.nettywebsocketserverhome.message.VideoShareLaunchMessage;
import scbc.liyongjie.nettywebsocketserverhome.result.Result;
import scbc.liyongjie.nettywebsocketserverhome.service.VideoShareLaunchService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 *
 */

@RestController
public class VideoShareLaunchController {

    private static final Logger log = LoggerFactory.getLogger(VideoShareLaunchController.class);

    @Resource
    private VideoShareLaunchService videoShareLaunchService;

    @PutMapping("/video/share/launch/send/")
    public Result<String> videoShareLaunch(@RequestParam(value = "sender_number")String senderNumber,
                                           @RequestParam(value = "sender_nickname")String senderNickname,
                                           @RequestParam(value = "sender_avatar")String senderAvatar,
                                           @RequestParam(value = "receiver")String receiver,
                                           @RequestParam(value = "shareVideoUUID")String shareVideoUUID,
                                           @RequestParam(value = "shareVideo")String shareVideo,
                                           @RequestParam(value = "shareVideoName") String shareVideoName,
                                           @RequestParam(value = "shareVideoThumbnail") String videoThumbnail){
        videoShareLaunchService.videoShareLaunchHandle(senderNumber,senderNickname,senderAvatar,receiver,shareVideoUUID,shareVideo,shareVideoName,videoThumbnail);
        return new Result<>("vide share launch success!");
    }

    @GetMapping("/get/video/share/launch/cache/")
    public Result<List<VideoShareLaunchMessage>> getVideoShareLaunchMessageCache(@RequestParam(value = "number")String number){
        List<VideoShareLaunchMessage> videoShareLaunchMessageList = videoShareLaunchService.getVideoShareLaunchMessageCache(number);
        log.info("getVideoShareLaunchMessageCache---[{}]",videoShareLaunchMessageList.toArray());
        return new Result<>(videoShareLaunchMessageList);
    }

}
