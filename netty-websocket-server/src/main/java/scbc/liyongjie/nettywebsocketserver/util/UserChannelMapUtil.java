package scbc.liyongjie.nettywebsocketserver.util;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import scbc.liyongjie.nettywebsocketserver.pojo.GroupChatMessage;
import scbc.liyongjie.nettywebsocketserver.pojo.PrivateChatMessage;
import scbc.liyongjie.nettywebsocketserver.result.Result;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 *          phoneNumber : Channel
 */
public class UserChannelMapUtil {

    private static final Logger log = LoggerFactory.getLogger(UserChannelMapUtil.class);

    //可以用来广播消息
    private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //实现点对点的消息传播--后期会整合kafka消息队列
    private static final Map<String, Channel> USER_CHANNEL = new ConcurrentHashMap<>(256);

    private static final String ID = "id";

    public synchronized static void doBind(String id,Channel channel){

        //之前该用户已经绑定过，再次绑定的时候需要从CHANNEL_GROUP删除该channel并且随手close
        if (USER_CHANNEL.containsKey(id)){
            Channel oldChannel = USER_CHANNEL.get(id);
            CHANNEL_GROUP.remove(oldChannel);
            oldChannel.close();
        }

        AttributeKey<String> attributeKey = AttributeKey.valueOf(ID);
        channel.attr(attributeKey).set(id);

        CHANNEL_GROUP.add(channel);
        USER_CHANNEL.put(id,channel);

        USER_CHANNEL.get(id).writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>("bind success!!!"))));
    }

    public synchronized static void unBind(String id){

        Channel channel = USER_CHANNEL.get(id);

        USER_CHANNEL.remove(id);
        CHANNEL_GROUP.remove(channel);

        if (!ObjectUtils.isEmpty(channel))
            channel.close();

    }

    public synchronized static void unBind(Channel channel){

        AttributeKey<String> attributeKey = AttributeKey.valueOf(ID);
        String id = channel.attr(attributeKey).get();

        if (!StringUtils.hasText(id)) {
            USER_CHANNEL.remove(id);
        }

        CHANNEL_GROUP.remove(channel);

        channel.close();

    }

    public static synchronized Map<String, Channel> getClient(){
        return USER_CHANNEL;
    }

    /**
     *
     * @param privateChatMessage 单聊消息实体
     */
    public static void sendMessageToAFriend(PrivateChatMessage privateChatMessage, Channel currentChannel){
        String receiver = privateChatMessage.getReceiver();
        Channel channel = USER_CHANNEL.get(receiver);

        //离线消息不做处理
        if (Objects.isNull(channel)) {
            currentChannel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>("离线消息----暂不处理"))));
            log.info("消息发送者-->{}向-->{}发送了一条离线单聊消息:{} ",privateChatMessage.getSender(),receiver,privateChatMessage.getMessage());
            return;
        }
        channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>(privateChatMessage))));
        log.info("消息发送者-->{}向-->{}发送了一条在线单聊消息:{} ",privateChatMessage.getSender(),receiver,privateChatMessage.getMessage());
    }

    /**
     *
     * @param message 群聊消息实体
     */
    public static void sendToAGroupMsg(GroupChatMessage message, Channel currentChannel){
        ArrayList<String> receivers = message.getReceivers();

        for(String receiver : receivers){
            Channel channel = USER_CHANNEL.get(receiver);
            if (!Objects.isNull(channel))
                channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(message)));
        }
        log.info("消息发送者-->{}向-->{}讨论群发送了一条消息:{} ",message.getSender(),message.getGroupName(),message.getMessage());

    }


}
