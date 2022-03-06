package scbc.liyongjie.servicessoapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import scbc.liyongjie.servicessoapi.interceptor.SsoInterceptor;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/6
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private SsoInterceptor ssoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ssoInterceptor);
    }
}
