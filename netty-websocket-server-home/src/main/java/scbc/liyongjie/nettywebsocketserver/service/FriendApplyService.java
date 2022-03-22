package scbc.liyongjie.nettywebsocketserver.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserver.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketserver.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserver.message.FriendApplyMessage;
import scbc.liyongjie.nettywebsocketserver.util.RedisUtils;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */

@Service
public class FriendApplyService {

    @Resource
    private RedisUtils redisUtils;

    /**
     *      发送好友申请------离线则缓存至数据库
     * @param senderUsername  申请人昵称
     * @param senderAvatar    申请人头像
     * @param senderNumber    申请人手机号
     * @param receiver    接受者手机号
     */
    public void friendApply(String senderUsername,String senderAvatar,String senderNumber,String receiver){
        if (UserChannelMapUtil.isOnline(receiver))
            onlineHandle(senderUsername,senderAvatar,senderNumber,receiver);//在线
        else
            offlineHandle(senderUsername, senderAvatar, senderNumber, receiver);//离线
    }

    private void onlineHandle(String senderUsername,String senderAvatar,String senderNumber,String receiver){
        Channel channel = UserChannelMapUtil.getChannel(receiver);
        if(Objects.isNull(channel)){
            offlineHandle(senderUsername, senderAvatar, senderNumber, receiver);
            return;
        }
        channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(buildFriendApplyMessage(senderUsername, senderAvatar, senderNumber, receiver))));
    }

    private void offlineHandle(String senderUsername,String senderAvatar,String senderNumber,String receiver){
        String json = redisUtils.get(RedisKeyPrefixEnums.FRIEND_APPLY.name()+receiver);
        List<FriendApplyMessage> friendApplyMessageList;

        if (!Objects.isNull(json))
            friendApplyMessageList = JSON.parseArray(json, FriendApplyMessage.class);
        else
            friendApplyMessageList = new ArrayList<>();

        friendApplyMessageList.add(buildFriendApplyMessage(senderUsername, senderAvatar, senderNumber,receiver));
        redisUtils.set(RedisKeyPrefixEnums.FRIEND_APPLY.name()+receiver, JSON.toJSONString(friendApplyMessageList));
    }

    private FriendApplyMessage buildFriendApplyMessage(String senderUsername,String senderAvatar,String senderNumber,String receiver){
        FriendApplyMessage friendApplyMessage = new FriendApplyMessage();
        friendApplyMessage.setType(MessageTypeEnum.FRIEND_APPLY.getType());
        friendApplyMessage.setMessage("用户:"+senderUsername+"向你发来一条好友申请!");
        friendApplyMessage.setReceiver(receiver);
        friendApplyMessage.setSenderNumber(senderNumber);
        friendApplyMessage.setSenderNickName(senderUsername);
        friendApplyMessage.setSenderAvatar(senderAvatar);
        return friendApplyMessage;
    }

    public List<FriendApplyMessage> getFriendApplyMessageCache(String number) {
        String json = redisUtils.get(RedisKeyPrefixEnums.FRIEND_APPLY.name()+number);

        if (Objects.isNull(json))
            return new ArrayList<>();//返回一个空列表

        redisUtils.delete(RedisKeyPrefixEnums.FRIEND_APPLY.name()+number);  //读完之后就得从缓存中删掉
        return JSON.parseArray(json, FriendApplyMessage.class);
    }

}
