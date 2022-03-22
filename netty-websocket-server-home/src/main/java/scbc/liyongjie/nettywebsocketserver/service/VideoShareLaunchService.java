package scbc.liyongjie.nettywebsocketserver.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import scbc.liyongjie.nettywebsocketserver.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketserver.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserver.message.FriendApplyMessage;
import scbc.liyongjie.nettywebsocketserver.message.VideoShareLaunchMessage;
import scbc.liyongjie.nettywebsocketserver.util.RedisUtils;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */

public class VideoShareLaunchService {

    @Resource
    private RedisUtils redisUtils;

    public void videoShareLaunchHandle(String senderNumber, String senderNickName,String senderAvatar, String receiver, String shareVideoUUID,String shareVideo,String shareVideoName) {
        if (UserChannelMapUtil.isOnline(senderNumber))
            onlineHandle(buildVideoShareLaunchMessage(senderNumber, senderNickName,senderAvatar, receiver, shareVideoUUID, shareVideo,shareVideoName));
        else offline(buildVideoShareLaunchMessage(senderNumber, senderNickName,senderAvatar, receiver, shareVideoUUID,shareVideo, shareVideoName));
    }

    private void onlineHandle(VideoShareLaunchMessage videoShareLaunchMessage){
        Channel channel = UserChannelMapUtil.getChannel(videoShareLaunchMessage.getSenderNumber());
        if (Objects.isNull(channel)){
            offline(videoShareLaunchMessage);
            return;
        }
        channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(videoShareLaunchMessage)));
    }

    private void offline(VideoShareLaunchMessage videoShareLaunchMessage){
        String json = redisUtils.get(RedisKeyPrefixEnums.VIDEO_SHARED_APPLY.name()+videoShareLaunchMessage.getSenderNumber());
        List<VideoShareLaunchMessage> videoShareLaunchMessageList;

        if (!Objects.isNull(json))
            videoShareLaunchMessageList = JSON.parseArray(json, VideoShareLaunchMessage.class);
        else
            videoShareLaunchMessageList = new ArrayList<>();

        videoShareLaunchMessageList.add(videoShareLaunchMessage);
        redisUtils.set(RedisKeyPrefixEnums.FRIEND_APPLY.name()+videoShareLaunchMessage.getSenderNumber(), JSON.toJSONString(videoShareLaunchMessageList));
    }
    
    private VideoShareLaunchMessage buildVideoShareLaunchMessage(String senderNumber, String senderNickName,String senderAvatar, String receiver, String shareVideoUUID,String shareVideo,String shareVideoName){
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
