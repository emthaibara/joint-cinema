package scbc.liyongjie.nettywebsocketservercinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@Configuration
public class RedisConfig {

    @Bean
    public StringRedisTemplate redisTemplate(LettuceConnectionFactory connectionFactory){
        StringRedisTemplate stringRedisTemplate  = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(connectionFactory);
        return stringRedisTemplate;
    }

}
