package scbc.liyongjie.serviceffmpegapi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 */

@Aspect
@Component
public class GrpcImplAspect {

    @Pointcut("execution(* scbc.liyongjie.serviceffmpegapi.service.FFmpegServiceProviderImpl.*(*))")
    public void GrpcImplPointcut(){}
}
