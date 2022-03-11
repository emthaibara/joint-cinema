package cn.scbc.servicevideouploadapi.advice;

import cn.scbc.servicevideouploadapi.grpc.FFmpegServiceConsumerGrpc;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */
@Aspect
@Component
public class GlobalAopAdvice {

    @Resource
    private FFmpegServiceConsumerGrpc fFmpegServiceConsumerGrpc;

    @After("cn.scbc.servicevideouploadapi.aspect.CommonAspect.FFmpegAspect()")
    public void ffmpegServiceAdvice(){

    }

}
