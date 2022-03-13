package scbc.liyongjie.nettywebsocketserver.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import scbc.liyongjie.nettywebsocketserver.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketserver.pojo.*;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2021/12/25
 */

//一定一定要标注共享handler实例，不然当用户多了，会new很多的WebSocketTextInboundHandler
@Component
@ChannelHandler.Sharable
public class WebSocketTextInboundHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(WebSocketTextInboundHandler.class);

    @Resource
    private SendMessageHandler sendMessageHandler;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String json = msg.text();
        handle(JSON.parseObject(json),ctx.channel());
    }

    private static final String TYPE = "type";
    private static final String DATA = "data";

    private void handle(JSONObject jsonObject, Channel channel) {

        final Integer type = jsonObject.getObject(TYPE,Integer.class);

        //不同消息类型区分不同的事务
        if (type.equals(MessageTypeEnum.BIND.getType())){
            sendMessageHandler.doBind(jsonObject.getObject(DATA, BindAskMessage.class),channel);
        }

        if (type.equals(MessageTypeEnum.PRIVATE_CHAT.getType())){
            sendMessageHandler.sendToAFriendMsg(jsonObject.getObject(DATA, PrivateChatMessage.class),channel);
        }

        if (type.equals(MessageTypeEnum.GROUP_CHAT.getType())){
            sendMessageHandler.sendToAGroupMsg(jsonObject.getObject(DATA, GroupChatMessage.class),channel);
        }

        if (type.equals(MessageTypeEnum.FORCE_OFFLINE.getType())){
            sendMessageHandler.sendForceOfflineMsg(jsonObject.getObject(DATA, ForceOfflineMessage.class),channel);
        }

        if (type.equals(MessageTypeEnum.FRIEND_REQUEST.getType())){
            sendMessageHandler.sendFriendRequestMsg(jsonObject.getObject(DATA, FriendRequestMessage.class),channel);
        }

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            log.info(ctx.channel().localAddress().toString());
        }
        else
            super.userEventTriggered(ctx,evt);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        UserChannelMapUtil.unBind(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常信息其实可以包装一下--这里简化了
        ctx.channel().writeAndFlush(cause.getMessage());
        ctx.close();
        log.error("异常信息："+cause.getMessage());
    }

}
