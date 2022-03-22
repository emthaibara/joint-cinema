package scbc.liyongjie.serviceffmpegapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ServiceFfmpegApiApplication{

    public static void main(String[] args) {
        SpringApplication.run(ServiceFfmpegApiApplication.class, args);
    }

}
