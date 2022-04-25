package scbc.liyongjie.nettywebsocketservercinema.handler;

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
import scbc.liyongjie.nettywebsocketservercinema.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketservercinema.message.*;
import scbc.liyongjie.nettywebsocketservercinema.util.UserChannelMapUtil;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 *
 */

@Component
@ChannelHandler.Sharable
public class WebSocketTextInboundHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(WebSocketTextInboundHandler.class);

    private static final String TYPE = "type";
    private static final String DATA = "data";

    @Resource
    private SendMessageHandler sendMessageHandler;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String json = textWebSocketFrame.text();
        log.info(json);
        handle(JSON.parseObject(json),channelHandlerContext.channel());
    }

    private void handle(JSONObject jsonObject, Channel channel) {
        final Integer type = jsonObject.getObject(TYPE,Integer.class);
        //不同消息类型区分不同的事务

       //doBind
        if (MessageTypeEnum.BIND.getType().equals(type))
            sendMessageHandler.doBind(jsonObject.getObject(DATA, BindAskMessage.class),channel);
        //暂停
        if (MessageTypeEnum.PAUSE.getType().equals(type))
            sendMessageHandler.pause(jsonObject.getObject(DATA, PauseMessage.class));
        //开始
            if (MessageTypeEnum.START.getType().equals(type))
                sendMessageHandler.start(jsonObject.getObject(DATA, StartMessage.class));
//        //拖动进度条
//                if (MessageTypeEnum.FAST_FORWARD.getType().equals(type))
//                    sendMessageHandler.fastForward(jsonObject.getObject(DATA, FastForwardMessage.class));
        //实时互动聊天类型
                        if (MessageTypeEnum.CHAT.getType().equals(type))
                            sendMessageHandler.chat(jsonObject.getObject(DATA, ChatMessage.class));
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

    private void clearCinemaData(){

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常信息其实可以包装一下--这里简化了
        ctx.channel().writeAndFlush(cause.getMessage());
        ctx.close();
        log.error("异常信息："+cause.getMessage());
    }

}

