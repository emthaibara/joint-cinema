package cn.scbc.service.audit.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.scbc.service.audit.api.dao")
public class ServiceAuditApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuditApiApplication.class, args);
    }

}
