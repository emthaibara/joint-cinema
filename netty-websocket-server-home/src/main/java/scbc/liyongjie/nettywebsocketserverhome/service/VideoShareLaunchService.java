package scbc.liyongjie.nettywebsocketserverhome.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserverhome.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketserverhome.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserverhome.message.VideoShareLaunchMessage;
import scbc.liyongjie.nettywebsocketserverhome.util.RedisUtils;
import scbc.liyongjie.nettywebsocketserverhome.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */
@Service
public class VideoShareLaunchService {

    private static final Logger log = LoggerFactory.getLogger(VideoShareLaunchService.class);

    @Resource
    private RedisUtils redisUtils;

    public void videoShareLaunchHandle(String senderNumber,
                                       String senderNickName,
                                       String senderAvatar,
                                       String receiver,
                                       String shareVideoUUID,
                                       String shareVideo,
                                       String shareVideoName,
                                       String videoThumbnail) {
        if (UserChannelMapUtil.isOnline(receiver))
            onlineHandle(buildVideoShareLaunchMessage(senderNumber, senderNickName,senderAvatar, receiver, shareVideoUUID, shareVideo,shareVideoName,videoThumbnail));
        else offline(buildVideoShareLaunchMessage(senderNumber, senderNickName,senderAvatar, receiver, shareVideoUUID,shareVideo, shareVideoName,videoThumbnail));
    }

    private void onlineHandle(VideoShareLaunchMessage videoShareLaunchMessage){
        Channel channel = UserChannelMapUtil.getChannel(videoShareLaunchMessage.getReceiver());
        if (Objects.isNull(channel)){
            offline(videoShareLaunchMessage);
            return;
        }
        channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(videoShareLaunchMessage)));
    }

    private void offline(VideoShareLaunchMessage videoShareLaunchMessage){
        String json = redisUtils.get(RedisKeyPrefixEnums.VIDEO_SHARED_APPLY.name()+videoShareLaunchMessage.getReceiver());
        List<VideoShareLaunchMessage> videoShareLaunchMessageList;

        if (!Objects.isNull(json))
            videoShareLaunchMessageList = JSON.parseArray(json, VideoShareLaunchMessage.class);
        else
            videoShareLaunchMessageList = new ArrayList<>();

        if (!videoShareLaunchMessageList.contains(videoShareLaunchMessage))
            videoShareLaunchMessageList.add(videoShareLaunchMessage);

        redisUtils.set(RedisKeyPrefixEnums.VIDEO_SHARED_APPLY.name()+videoShareLaunchMessage.getReceiver(), JSON.toJSONString(videoShareLaunchMessageList));
    }
    
    private VideoShareLaunchMessage buildVideoShareLaunchMessage(String senderNumber,
                                                                 String senderNickName,
                                                                 String senderAvatar,
                                                                 String receiver,
                                                                 String shareVideoUUID,
                                                                 String shareVideo,
                                                                 String shareVideoName,
                                                                 String videoThumbnail){
        VideoShareLaunchMessage videoShareLaunchMessage = new VideoShareLaunchMessage();
        videoShareLaunchMessage.setType(MessageTypeEnum.SHARE_VIDEO_LAUNCH.getType());
        videoShareLaunchMessage.setMessage("用户:"+senderNickName+"向你发起视频共享");
        videoShareLaunchMessage.setReceiver(receiver);
        videoShareLaunchMessage.setSenderNumber(senderNumber);
        videoShareLaunchMessage.setSenderNickName(senderNickName);
        videoShareLaunchMessage.setSenderAvatar(senderAvatar);
        videoShareLaunchMessage.setVideoName(shareVideoName);
        videoShareLaunchMessage.setShareVideo(shareVideo);
        videoShareLaunchMessage.setShareVideoUUID(shareVideoUUID);
        videoShareLaunchMessage.setVideoThumbnail(videoThumbnail);
        log.info(videoShareLaunchMessage.toString());
        return videoShareLaunchMessage;
    }

    public List<VideoShareLaunchMessage> getVideoShareLaunchMessageCache(String number){
        String json = redisUtils.get(RedisKeyPrefixEnums.VIDEO_SHARED_APPLY.name()+number);

        if (Objects.isNull(json))
            return new ArrayList<>();//返回一个空列表

        redisUtils.delete(RedisKeyPrefixEnums.VIDEO_SHARED_APPLY.name()+number);  //读完之后就得从缓存中删掉
        return JSON.parseArray(json, VideoShareLaunchMessage.class);
    }

}
