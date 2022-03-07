package scbc.liyongjie.servicessoapi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import scbc.liyongjie.servicessoapi.dao.UserPoMapper;
import scbc.liyongjie.servicessoapi.enums.PrefixEnum;
import scbc.liyongjie.servicessoapi.exception.UnRegisteredException;
import scbc.liyongjie.servicessoapi.util.RedisUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/6
 */
@Component
public class SsoInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SsoInterceptor.class);

    @Resource
    private UserPoMapper userPoMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String number = getNumber(request);
        isExist(number);  //是否已注册

        isOnline(number);   //是否登录在线状态

        return Boolean.TRUE;
    }

    private String getNumber(HttpServletRequest request){
        return request.getHeader(PrefixEnum.NUMBER.getPrefix());
    }

    /**
     * 判断该手机号是否注册
     * @param number 手机号
     */
    private void isExist(String number) throws IOException {
        log.info("正在拦截检查..."+number);
        if (Objects.isNull(userPoMapper.selectByPrimaryKey(number)))
            throw new UnRegisteredException();
    }

    /**
     * 判断该手机号对应的用户 是否已经登录并使其jwt token 失效
     * @param number 手机号
     */
    private void isOnline(String number){
        if (redisUtil.hasKey(PrefixEnum.NUMBER.getPrefix()+number)){
            String token = redisUtil.get(PrefixEnum.NUMBER.getPrefix()+number);
            redisUtil.delete(PrefixEnum.NUMBER.getPrefix()+number);
            redisUtil.delete(PrefixEnum.TOKEN.getPrefix()+token);
        }
    }

}
