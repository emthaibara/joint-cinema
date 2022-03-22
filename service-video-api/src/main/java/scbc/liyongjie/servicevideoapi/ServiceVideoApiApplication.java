package scbc.liyongjie.servicevideoapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("scbc.liyongjie.servicevideoapi.dao")
@EnableEurekaClient
public class ServiceVideoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVideoApiApplication.class, args);
    }

}
