package scbc.liyongjie.nettywebsocketserverhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import scbc.liyongjie.nettywebsocketserverhome.server.NettyServer;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("scbc.liyongjie.nettywebsocketserverhome.dao")
@EnableEurekaClient
public class NettyWebsocketServerHomeApplication implements CommandLineRunner {

    @Resource
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyWebsocketServerHomeApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        nettyServer.start();
        //确保springboot整个项目关闭时，nettyServer要关闭
        Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
    }

}
