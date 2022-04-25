package scbc.liyongjie.servicenicknameapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "scbc.liyongjie.servicenicknameapi.dao")
@EnableEurekaClient
public class ServiceNicknameApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNicknameApiApplication.class, args);
    }

}
