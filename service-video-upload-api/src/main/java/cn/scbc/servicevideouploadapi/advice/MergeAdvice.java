package cn.scbc.servicevideouploadapi.advice;

import cn.scbc.servicevideouploadapi.service.MergeService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

@Aspect
@Component
public class MergeAdvice {

    @Resource
    private MergeService mergeService;

    @After("cn.scbc.servicevideouploadapi.aspect.CommonAspect.mergeAspect()")
    public void mergeServiceAdvice(JoinPoint joinPoint){

    }

}
