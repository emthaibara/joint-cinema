package scbc.liyongjie.nettywebsocketservercinema.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import scbc.liyongjie.nettywebsocketservercinema.handler.WebSocketTextInboundHandler;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2021/12/20
 *
 */

@Component
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class SocketChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    @Value("${netty.server.websocket.path}")
    private String handshakePath;

    @Resource
    private WebSocketTextInboundHandler webSocketTextInboundHandler;

    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

        nioSocketChannel
                .pipeline()
                //http请求解码器，websocket建立之前首先需要发送一个http请求，请求升级协议
                .addLast(new HttpServerCodec())
                //消息聚合器，解决粘包半包等问题
                .addLast(new HttpObjectAggregator(65536))
                //netty封装的专门用于处理websocket连接的各种事务处理，如ping pong 请求的处理，协议升级
                .addLast(new WebSocketServerProtocolHandler(handshakePath))
                //websocket连接建立后，文本消息处理器
                .addLast(webSocketTextInboundHandler);

    }

}
