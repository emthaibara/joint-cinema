package scbc.liyongjie.servicesignapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("scbc.liyongjie.servicesignapi.dao")
public class ServiceSignApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSignApiApplication.class, args);
    }

}
