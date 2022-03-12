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

    @Pointcut("execution(* cn.scbc.servicevideouploadapi.service.MergeService.merge(*))")
    public void ffmpegAspect(){}

    @Pointcut("execution(* cn.scbc.servicevideouploadapi.controller.UploadController.mergeChunk(*))")
    public void mergeAspect(){}

}
