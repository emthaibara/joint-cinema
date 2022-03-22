package scbc.liyongjie.servicenicknameapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/23
 */
@Component
@Aspect
public class CommonAspect {

    @Pointcut("@annotation(scbc.liyongjie.servicenicknameapi.aspect.NickNameValidateAop)")
    public void checkNickNameAspect(){}

}
