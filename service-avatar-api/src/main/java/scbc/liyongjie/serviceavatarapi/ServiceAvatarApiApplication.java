package scbc.liyongjie.serviceavatarapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("scbc.liyongjie.serviceavatarapi.dao")
@EnableEurekaClient
public class ServiceAvatarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAvatarApiApplication.class, args);
    }

}
