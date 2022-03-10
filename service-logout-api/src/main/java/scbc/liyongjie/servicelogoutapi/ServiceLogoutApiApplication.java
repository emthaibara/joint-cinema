package scbc.liyongjie.servicelogoutapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceLogoutApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceLogoutApiApplication.class, args);
    }

}


