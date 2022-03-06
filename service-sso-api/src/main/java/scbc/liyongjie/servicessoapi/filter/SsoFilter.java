package scbc.liyongjie.servicessoapi.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import scbc.liyongjie.servicessoapi.dao.NumberPoMapper;
import scbc.liyongjie.servicessoapi.enums.PrefixEnum;
import scbc.liyongjie.servicessoapi.exception.LoginException;
import scbc.liyongjie.servicessoapi.util.RedisUtil;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 *          request到controller之前(实际上位于请求的最上游位置拦截过滤)
 *          拦截请求，用于判断该 1.用户是否注册
 *                           2.该账号是否已经被登录---已登录则使其jwt token失效 / 否则放行
 */

@Order(1)
@WebFilter(filterName = "SsoFilter", urlPatterns = {"/mycinema/sso"})
@Component
public class SsoFilter implements Filter {

    @Resource
    private NumberPoMapper numberPoMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String number = getNumber(servletRequest);

        isExist(number);    //是否已注册
        isOnline(number);   //是否登录在线状态

        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     *  从header中拿到number
     * @param servletRequest request
     * @return  返回number
     */
    private String getNumber(ServletRequest servletRequest){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        return request.getHeader(PrefixEnum.NUMBER.getPrefix());
    }

    /**
     * 判断该手机号是否注册
     * @param number 手机号
     */
    private void isExist(String number){
        if (Objects.isNull(numberPoMapper.selectByPrimaryKey(number)))
            throw new LoginException();     //快速失败
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
