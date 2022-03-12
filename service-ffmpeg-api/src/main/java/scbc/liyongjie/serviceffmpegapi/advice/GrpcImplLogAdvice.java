package scbc.liyongjie.serviceffmpegapi.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 */

@Component
@Aspect
public class GrpcImplLogAdvice {

    @Around("scbc.liyongjie.serviceffmpegapi.aspect.GrpcImplAspect.GrpcImplPointcut()")
    public Object grpcImplLog(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
