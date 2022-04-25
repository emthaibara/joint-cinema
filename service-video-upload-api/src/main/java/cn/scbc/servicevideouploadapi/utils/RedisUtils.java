package cn.scbc.servicevideouploadapi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/3
 *          redis 工具类
 */
@Component
public class RedisUtils {

    private final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     *  通过key 查找对应的 value
     * @param key key
     * @return 查找到返回value 否则 返回 null
     */
    public String get(String key) {
        return Objects.isNull(key) ? null : stringRedisTemplate.opsForValue().get(key);
    }

    /**
     *
     * @param key key
     * @param value value
     * @return  false or true
     */
    public Boolean set(String key, String value) {
        try {
            stringRedisTemplate.opsForValue().set(key , value);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

    /**
     * 根据key 获取数据的到期时间(s)
     * @param key key
     * @return 0(forever) or expire (s) or null(key does not exist)
     */
    public Long getExpire(String key) {
        return stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * put数据并设置到期时间
     * @param key key
     * @param value value
     * @param time 到期时间 ，若time小于0则会设置成无期限，单位(s)
     * @return false or true
     */
    public Boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
                return Boolean.TRUE;
            } else {
                return set(key, value);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

    /**
     * 指定key对应的数据的到期时间
     * @param key key
     * @param time  expire time (s)
     * @return false or true , null
     */
    public Boolean expire(String key, long time) {
        try {
            if (time >= 0) {
                return stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
            }else {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

    /**
     * 判断是否存在key
     * @param key key
     * @return false or true
     */
    public Boolean hasKey(String key) {
        try {
            return stringRedisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

    /**
     *  不定参数传入多个key，并删除对应的数据
     * @param keys 单个或多个key
     */
    public void delete(String... keys){
        if (!Objects.isNull(keys) && keys.length > 0) {
            if (keys.length == 1) {
                stringRedisTemplate.delete(keys[0]);
            } else {
                stringRedisTemplate.delete(Arrays.asList(keys));
            }
        }
    }
}
