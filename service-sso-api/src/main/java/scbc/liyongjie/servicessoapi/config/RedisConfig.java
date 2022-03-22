package scbc.liyongjie.servicessoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/3
 */

@Configuration
public class RedisConfig {

    @Bean
    public StringRedisTemplate redisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }

}
