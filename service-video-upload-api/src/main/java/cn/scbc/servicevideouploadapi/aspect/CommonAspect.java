package cn.scbc.servicevideouploadapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */

@Aspect
@Component
public class CommonAspect {

    @Pointcut("@annotation(cn.scbc.servicevideouploadapi.aspect.annotation.FFmpegAop)")
    public void ffmpegAspect(){}

}

