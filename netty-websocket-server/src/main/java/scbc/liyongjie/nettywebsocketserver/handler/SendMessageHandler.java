package scbc.liyongjie.nettywebsocketserver.handler;

import io.netty.channel.Channel;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserver.enums.TokenClaimEnum;
import scbc.liyongjie.nettywebsocketserver.message.*;
import scbc.liyongjie.nettywebsocketserver.util.JwtUtil;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 *
 */

@Service
public class SendMessageHandler {

    public void sendToAFriendMsg(PrivateChatMessage message, Channel currentChannel){
        UserChannelMapUtil.sendMessageToAFriend(message,currentChannel);
    }

    public void sendToAGroupMsg(GroupChatMessage message, Channel currentChannel){
        UserChannelMapUtil.sendToAGroupMsg(message,currentChannel);
    }

    public void sendFriendRequestMsg(FriendRequestMessage message, Channel currentChannel){

    }

    public void sendForceOfflineMsg(ForceOfflineMessage message, Channel currentChannel){

    }

    public void doBind(BindAskMessage message, Channel channel){
        String token = message.getToken();
        String id = JwtUtil.getClaim(TokenClaimEnum.ID,token);
        UserChannelMapUtil.doBind(id,channel);
    }

}
