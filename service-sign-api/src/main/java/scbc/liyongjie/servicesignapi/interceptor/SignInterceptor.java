package scbc.liyongjie.servicesignapi.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import scbc.liyongjie.servicesignapi.dao.NumberPoMapper;
import scbc.liyongjie.servicesignapi.exception.SignException;

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
public class SignInterceptor implements HandlerInterceptor {

    private static final String PREFIX = "number";

    @Resource
    private NumberPoMapper numberPoMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
    private void isExist(String number) throws IOException {
        if (!Objects.isNull(numberPoMapper.selectByPrimaryKey(number)))
            throw new SignException();
    }

}
