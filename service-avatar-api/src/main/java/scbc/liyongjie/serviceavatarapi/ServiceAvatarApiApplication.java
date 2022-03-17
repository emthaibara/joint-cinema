package scbc.liyongjie.serviceavatarapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("scbc.liyongjie.serviceavatarapi.dao")
public class ServiceAvatarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAvatarApiApplication.class, args);
    }

}
