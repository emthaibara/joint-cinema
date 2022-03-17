package scbc.liyongjie.servicevideoapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("scbc.liyongjie.servicevideoapi.dao")
public class ServiceVideoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVideoApiApplication.class, args);
    }

}
