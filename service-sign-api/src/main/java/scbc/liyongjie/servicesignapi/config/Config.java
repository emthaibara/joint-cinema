package scbc.liyongjie.servicesignapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.text.SimpleDateFormat;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */

@Configuration
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class Config {

    @Value("${date.format}")
    private String format;

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat(format);
    }

}
