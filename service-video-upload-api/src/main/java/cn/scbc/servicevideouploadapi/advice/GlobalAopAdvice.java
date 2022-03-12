package cn.scbc.servicevideouploadapi.advice;

import cn.scbc.servicevideouploadapi.grpc.FFmpegServiceConsumerGrpc;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import org.aspectj.lang.JoinPoint;
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
    public void ffmpegServiceAdvice(JoinPoint joinPoint){
        Object var = joinPoint.getArgs()[0];
        MergeChunkPoJo mergeChunkPoJo = (MergeChunkPoJo) var;
        //首先计算视频时长

        // 缩略图+dash流


        //最后删除视频，只保留切片+mpd+缩略图.jpeg

        //最后将 相关数据存储数据库

    }

}
