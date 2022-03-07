package scbc.liyongjie.servicesignapi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import scbc.liyongjie.servicesignapi.dao.UserPoMapper;
import scbc.liyongjie.servicesignapi.exception.SignException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/6
 */
@Component
public class SignInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SignInterceptor.class);

    private static final String PREFIX = "number";

    @Resource
    private UserPoMapper userPoMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        isExist(getNumber(request));
        return Boolean.TRUE;
    }

    private String getNumber(HttpServletRequest request){
        return request.getHeader(PREFIX);
    }

    /**
     * 判断该手机号是否注册
     * @param number 手机号
     */
    private void isExist(String number) {
        log.info("正在拦截检查..."+number);
        if (!Objects.isNull(userPoMapper.selectByPrimaryKey(number)))
            throw new SignException();
    }

}
