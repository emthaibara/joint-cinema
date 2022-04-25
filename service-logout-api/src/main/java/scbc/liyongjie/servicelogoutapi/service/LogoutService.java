package scbc.liyongjie.servicelogoutapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.servicelogoutapi.enums.PrefixEnum;
import scbc.liyongjie.servicelogoutapi.util.JwtUtils;
import scbc.liyongjie.servicelogoutapi.util.RedisUtils;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */

@Service
public class LogoutService {

    private static final Logger log = LoggerFactory.getLogger(LogoutService.class);

    @Resource
    private RedisUtils redisUtils;

    public void logout(String token){
        String number = JwtUtils.getClime(token);
        log.info(PrefixEnum.NUMBER+number);
        log.info(PrefixEnum.TOKEN+token);
        redisUtils.delete(PrefixEnum.NUMBER.getPrefix()+number,PrefixEnum.TOKEN.getPrefix()+token);
    }

}

