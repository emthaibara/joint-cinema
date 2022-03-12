package scbc.liyongjie.servicesignapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 */

@Aspect
@Component
public class SignAspect {

    @Pointcut("execution(* scbc.liyongjie.servicesignapi.service.SignService.login(*))")
    public void signAspect(){}

}
