package scbc.liyongjie.nettywebsocketservercinema.handler;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;
import scbc.liyongjie.nettywebsocketservercinema.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketservercinema.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketservercinema.message.*;
import scbc.liyongjie.nettywebsocketservercinema.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketservercinema.pojo.ChatPoJo;
import scbc.liyongjie.nettywebsocketservercinema.result.Result;
import scbc.liyongjie.nettywebsocketservercinema.util.RedisUtils;
import scbc.liyongjie.nettywebsocketservercinema.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 *              aop分离token验证事务
 */

@Component
public class SendMessageHandler {

    @Resource
    private RedisUtils redisUtils;

    /**
     *      初始化绑定用户---channel
     * @param message   BindAskMessage
     * @param channel   Channel
     */
    public void doBind(BindAskMessage message, Channel channel){
        UserChannelMapUtil.doBind(message.getNumber(),channel);
    }

    /**
     *  协同----开始
     */
    public synchronized void start(StartMessage startMessage){
        List<String> member = getMember(startMessage.getCinemaUUID());
        if(!Objects.isNull(member)){
            sendMessage(startMessage.getCinemaUUID(),MessageTypeEnum.START.getType(), member);
        }
    }

    /**
     * 协同----暂停
     */
    public synchronized void pause(PauseMessage pauseMessage ){
        List<String> member = getMember(pauseMessage.getCinemaUUID());
        if(!Objects.isNull(member)){
            sendMessage(pauseMessage.getCinemaUUID(),MessageTypeEnum.PAUSE.getType(), member);
        }
    }

    /**
     * 协同----快进
     */
//    public synchronized void fastForward(FastForwardMessage fastForwardMessage){
//        List<String> member = getMember(fastForwardMessage.getCinemaUUID());
//        if(!Objects.isNull(member)){
//            sendMessage(fastForwardMessage.getCinemaUUID(), MessageTypeEnum.FAST_FORWARD.getType(),member);
//        }
//    }

    /**
     *  实时互动聊天
     */
    public synchronized void chat(ChatMessage chatMessage){

        List<String> member = getMember(chatMessage.getCinemaUUID());

        if(!Objects.isNull(member)){
            System.out.println(Arrays.toString(member.toArray()));
            String homeownerNumber = getHomeownerNumber(chatMessage.getCinemaUUID());

            if (member.contains(chatMessage.getSenderNumber())){
                member.remove(chatMessage.getSenderNumber());
                member.add(homeownerNumber);
            }
            System.out.println(Arrays.toString(member.toArray()));

            for (String receiver : member){
                Channel channel = UserChannelMapUtil.getChannel(receiver);
                if (!Objects.isNull(channel)){
                    ChatPoJo chatPoJo = new ChatPoJo();
                    chatPoJo.setMessage(chatMessage.getMessage());
                    chatPoJo.setSenderAvatar(chatMessage.getSenderAvatar());
                    chatPoJo.setSenderName(chatMessage.getSenderName());
                    System.out.println(chatPoJo.toString());
                    channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>(MessageTypeEnum.CHAT.getType(),chatPoJo))));
                }
            }

        }
    }


    private List<String> getMember(String cinemaUUID){
        String json = redisUtils.get(RedisKeyPrefixEnums.CINEMA+cinemaUUID);
        if (!Objects.isNull(json))  {
            BuildCinemaPoJo cinemaPoJo = JSON.parseObject(json,BuildCinemaPoJo.class);
            return cinemaPoJo.getMember();
        }
        return null;
    }

    private String getHomeownerNumber(String cinemaUUID){
        String json = redisUtils.get(RedisKeyPrefixEnums.CINEMA+cinemaUUID);
        if (!Objects.isNull(json))  {
            BuildCinemaPoJo cinemaPoJo = JSON.parseObject(json,BuildCinemaPoJo.class);
            return cinemaPoJo.getHomeowner_number();
        }
        return null;
    }

    private void sendMessage(String cinemaUUID,Integer type,List<String> receivers){
        for (String receiver : receivers){
            Channel channel = UserChannelMapUtil.getChannel(receiver);
            if (!Objects.isNull(channel)){
                channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(new Result<>(type,null))));
            }
        }
    }



}
