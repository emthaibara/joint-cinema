package scbc.liyongjie.servicenicknameapi.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import scbc.liyongjie.servicenicknameapi.exception.NickNameException;

import java.util.regex.Pattern;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/23
 */
@Component
@Aspect
public class NickNameValidateAdvice {

    private static final String RE = "^[\\d\\w\\u4e00-\\u9fa5,\\.;\\:\"'?!\\-]{2,15}$";

    @Before("scbc.liyongjie.servicenicknameapi.aspect.CommonAspect.checkNickNameAspect()")
    public void nickNameValidate(JoinPoint joinPoint){
        String  nickNameObj = (String)joinPoint.getArgs()[1];
        if (!Pattern.matches(RE,nickNameObj))
            throw new NickNameException();
    }
}
