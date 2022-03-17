package scbc.liyongjie.nettywebsocketserver.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import scbc.liyongjie.nettywebsocketserver.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserver.message.apply.VideoShareLaunchMessage;
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

    public void videoShareLaunchHandle(String number, String username, String receiver, String shareVideoUrl,String shareVideoName) {
        if (UserChannelMapUtil.isOnline(number))
            onlineHandle(buildVideoShareLaunchMessage(number, username, receiver, shareVideoUrl, shareVideoName));
        else offline(buildVideoShareLaunchMessage(number, username, receiver, shareVideoUrl, shareVideoName));
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

    private static final Integer VIDEO_SHARE_LAUNCH_TYPE = 2;
    private VideoShareLaunchMessage buildVideoShareLaunchMessage(String number, String username, String receiver, String shareVideoUrl,String shareVideoName){
        VideoShareLaunchMessage videoShareLaunchMessage = new VideoShareLaunchMessage();
        videoShareLaunchMessage.setType(VIDEO_SHARE_LAUNCH_TYPE);
        videoShareLaunchMessage.setMessage("用户:"+username+"向你发起视频共享");
        videoShareLaunchMessage.setReceiver(receiver);
        videoShareLaunchMessage.setSenderNumber(number);
        videoShareLaunchMessage.setSenderNickName(username);
        videoShareLaunchMessage.setVideoName(shareVideoName);
        videoShareLaunchMessage.setVideoUrl(shareVideoUrl);
        return videoShareLaunchMessage;
    }

}
