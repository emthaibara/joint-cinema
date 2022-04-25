package cn.scbc.servicevideouploadapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.scbc.servicevideouploadapi.dao")
public class ServiceVideoUploadApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVideoUploadApiApplication.class, args);
    }
}