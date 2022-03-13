package cn.scbc.servicevideouploadapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("cn.scbc.servicevideouploadapi.dao")
@EnableAsync
public class ServiceVideoUploadApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVideoUploadApiApplication.class, args);
    }

}
