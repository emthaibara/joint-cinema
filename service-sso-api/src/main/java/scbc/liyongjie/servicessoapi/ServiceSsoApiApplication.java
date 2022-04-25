package scbc.liyongjie.servicessoapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("scbc.liyongjie.servicessoapi.dao")
public class ServiceSsoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSsoApiApplication.class, args);
    }

}
