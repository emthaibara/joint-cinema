package scbc.liyongjie.servicevideoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/23
 */

@Configuration
public class Config {

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

}
