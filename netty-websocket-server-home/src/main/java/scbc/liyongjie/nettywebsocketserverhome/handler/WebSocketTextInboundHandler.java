package scbc.liyongjie.nettywebsocketserverhome.handler;

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
import scbc.liyongjie.nettywebsocketserverhome.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketserverhome.message.BindAskMessage;
import scbc.liyongjie.nettywebsocketserverhome.util.UserChannelMapUtil;

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
        log.info(json);
        handle(JSON.parseObject(json),ctx.channel());
    }

    private static final String TYPE = "type";
    private static final String DATA = "data";

    private void handle(JSONObject jsonObject, Channel channel) {

        final Integer type = jsonObject.getObject(TYPE,Integer.class);

        //初始化连接绑定消息类型
        if (type.equals(MessageTypeEnum.BIND.getType())){
            sendMessageHandler.doBind(jsonObject.getObject(DATA, BindAskMessage.class),channel);
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
        //UserChannelMapUtil.unBind(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        UserChannelMapUtil.unBind(ctx.channel());
        log.info("客户端断开连接，channel的长ID：[{}]", ctx.channel().id().asLongText());
        log.info("客户端断开连接，channel的短ID：[{}]", ctx.channel().id().asShortText());
        log.info("USER_CHANNEL---Map----status---{}", UserChannelMapUtil.getClient().entrySet().toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常信息其实可以包装一下--这里简化了
        ctx.channel().writeAndFlush(cause.getMessage());
        ctx.close();
        log.error("异常信息："+cause.getMessage());
    }

}
