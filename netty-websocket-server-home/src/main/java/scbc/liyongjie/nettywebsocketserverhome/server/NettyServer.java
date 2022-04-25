package scbc.liyongjie.nettywebsocketserverhome.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2021/12/19
 *          构建netty服务器的启动引导类
 *          并添加为bean
 */

@Configuration
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class NettyServer {

    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    // 服务端NIO线程组
    private final EventLoopGroup boosGroup = new NioEventLoopGroup();
    private final EventLoopGroup workGroup = new NioEventLoopGroup();

    @Value("${netty.server.socketAddress.port}")
    private int port;

    private Channel channel;

    @Resource
    private SocketChannelInitializer socketChannelInitializer;

    public void start() {
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(boosGroup, workGroup)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 500)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(socketChannelInitializer);

            // 绑定端口并异步等待
            channel = serverBootstrap.bind(port).sync().channel();

            logger.info("======Start Up Success!=========");
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    @PreDestroy
    public void destroy() {
        logger.info("=================Netty服务关闭==================");
        if (!Objects.isNull(channel))
            channel.close();
        boosGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }

}
