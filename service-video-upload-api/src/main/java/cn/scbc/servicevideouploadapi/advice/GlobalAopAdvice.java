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
        //创建文件夹视频文件夹----用户注册成功的时候

        //首先计算视频时长

        //然后传递时长+originPath+targetPath

        //最后删除视频，只保留切片+mpd+缩略图.jpeg

        //最后将 相关数据存储数据库

    }

}
