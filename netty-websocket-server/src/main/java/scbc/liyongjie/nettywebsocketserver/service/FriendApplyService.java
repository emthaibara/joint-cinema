package scbc.liyongjie.nettywebsocketserver.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserver.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserver.message.apply.FriendApplyMessage;
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
     * @param username  申请人昵称
     * @param sender    申请人手机号
     * @param number    接受者手机号
     */
    public void friendApply(String username,String sender,String number){
        if (UserChannelMapUtil.isOnline(number))
            onlineHandle(username,sender,number);//在线
        else
            offlineHandle(username,sender,number);//离线
    }

    private void onlineHandle(String username,String sender,String number){
        Channel channel = UserChannelMapUtil.getChannel(number);
        if(Objects.isNull(channel)){
            offlineHandle(username, sender, number);
            return;
        }
        channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(buildFriendApplyMessage(username,sender,number))));
    }

    private void offlineHandle(String username,String sender,String number){
        String json = redisUtils.get(RedisKeyPrefixEnums.FRIEND_APPLY.name()+sender);
        List<FriendApplyMessage> friendApplyMessageList;

        if (!Objects.isNull(json))
            friendApplyMessageList = JSON.parseArray(json, FriendApplyMessage.class);
        else
            friendApplyMessageList = new ArrayList<>();

        friendApplyMessageList.add(buildFriendApplyMessage(username, sender, number));
        redisUtils.set(RedisKeyPrefixEnums.FRIEND_APPLY.name()+sender, JSON.toJSONString(friendApplyMessageList));
    }

    private static final Integer FRIEND_APPLY_TYPE = 1;
    private FriendApplyMessage buildFriendApplyMessage(String username,String sender,String number){
        FriendApplyMessage friendApplyMessage = new FriendApplyMessage();
        friendApplyMessage.setType(FRIEND_APPLY_TYPE);
        friendApplyMessage.setMessage("用户:"+username+"向你发来一条好友申请!");
        friendApplyMessage.setReceiver(number);
        friendApplyMessage.setSenderNumber(sender);
        friendApplyMessage.setSenderNickName(username);
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
