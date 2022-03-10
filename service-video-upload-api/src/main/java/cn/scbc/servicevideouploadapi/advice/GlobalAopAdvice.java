package cn.scbc.servicevideouploadapi.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */
@Aspect
@Component
public class GlobalAopAdvice {



    @After("cn.scbc.servicevideouploadapi.aspect.CommonAspect.FFmpegAspect()")
    public void ffmpegServiceAdvice(){

    }

}
