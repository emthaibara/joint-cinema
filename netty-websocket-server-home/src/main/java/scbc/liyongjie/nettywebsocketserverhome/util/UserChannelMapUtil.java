package scbc.liyongjie.nettywebsocketserverhome.util;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import scbc.liyongjie.nettywebsocketserverhome.message.BindSuccessMessage;

import java.util.Map;
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
    private static final Map<Channel, String> CHANNEL_USER = new ConcurrentHashMap<>(256);

    //id -- number 手机号绑定
    public synchronized static void doBind(String id,Channel channel){

        //之前该用户已经绑定过，再次绑定的时候需要从CHANNEL_GROUP删除该channel并且随手close
        if (USER_CHANNEL.containsKey(id)){
            Channel oldChannel = USER_CHANNEL.get(id);
            CHANNEL_GROUP.remove(oldChannel);
            CHANNEL_USER.remove(oldChannel);
            oldChannel.close();
        }

        CHANNEL_GROUP.add(channel);
        USER_CHANNEL.put(id,channel);
        CHANNEL_USER.put(channel,id);

        USER_CHANNEL.get(id).writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new BindSuccessMessage())));
    }

    //根据id断开连接
    public synchronized static void unBind(String id){

        Channel channel = USER_CHANNEL.get(id);

        USER_CHANNEL.remove(id);
        CHANNEL_GROUP.remove(channel);

        if (!ObjectUtils.isEmpty(channel))
            channel.close();

    }

    //根据通道channel断开连接
    public synchronized static void unBind(Channel channel){
        String id = CHANNEL_USER.get(channel);
        log.info("user id----{}---正在close...",id);
        CHANNEL_USER.remove(channel);
        USER_CHANNEL.remove(id);
        CHANNEL_GROUP.remove(channel);
        channel.close();
        log.info(USER_CHANNEL.entrySet().toString());
    }

    //获取连接
    public static synchronized Map<String, Channel> getClient(){
        return USER_CHANNEL;
    }

    /**
     *      区分在线离线好友
     * @param number    电话号码
     * @return  返回值
     */
    public static Boolean isOnline(String number){
        return USER_CHANNEL.containsKey(number);
    }

    //获取通道
    public static Channel getChannel(String number){
        return USER_CHANNEL.get(number);
    }

}
