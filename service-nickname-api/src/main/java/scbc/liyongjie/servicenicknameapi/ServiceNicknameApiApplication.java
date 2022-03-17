package scbc.liyongjie.servicenicknameapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("scbc.liyongjie.servicenicknameapi.dao")
public class ServiceNicknameApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNicknameApiApplication.class, args);
    }

}
