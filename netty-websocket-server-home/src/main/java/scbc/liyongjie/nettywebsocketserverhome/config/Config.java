package scbc.liyongjie.nettywebsocketserverhome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/25
 */

@Configuration
public class Config {
    @Bean
    public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory connectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(connectionFactory);
        return stringRedisTemplate;
    }

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域
        config.addAllowedOrigin("*");
        //是否发送Cookie信息
        config.setAllowCredentials(false);
        //放行哪些原始域(请求方式)
        config.addAllowedMethod("*");
        //放行哪些原始域(头部信息)
        config.addAllowedHeader("*");
        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }

}
