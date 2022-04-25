package scbc.liyongjie.nettywebsocketservercinema.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@Component
public class NettyServer {

    private static final Logger log = LoggerFactory.getLogger(NettyServer.class);

    private static final Integer PORT = 3030;

    // 服务端NIO线程组
    private final EventLoopGroup boosGroup = new NioEventLoopGroup();
    private final EventLoopGroup workGroup = new NioEventLoopGroup();

    private Channel channel;

    @Resource
    private SocketChannelInitializer socketChannelInitializer;

    public void start(){
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(boosGroup, workGroup)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 500)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(socketChannelInitializer);

            // 绑定端口并异步等待
            channel = serverBootstrap.bind(PORT).sync().channel();

            log.info("======Start Up Success!=========");
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    //销毁
    @PreDestroy
    public void destroy() {
        log.info("=================Netty服务关闭==================");
        if (!Objects.isNull(channel))
            channel.close();
        boosGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }

}
