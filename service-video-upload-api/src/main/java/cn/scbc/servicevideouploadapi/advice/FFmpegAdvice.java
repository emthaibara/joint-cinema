package cn.scbc.servicevideouploadapi.advice;

import cn.scbc.servicevideouploadapi.grpc.FFmpegServiceConsumerGrpc;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */

@Aspect
@Component
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class FFmpegAdvice {

    @Resource
    private FFmpegServiceConsumerGrpc fFmpegServiceConsumerGrpc;

    @Resource
    private SimpleDateFormat simpleDateFormat;

    @After("cn.scbc.servicevideouploadapi.aspect.CommonAspect.ffmpegAspect()")
    public void ffmpegServiceAdvice(JoinPoint joinPoint){
        Object var1 = joinPoint.getArgs()[0];
        Object var2 = joinPoint.getArgs()[1];
        MergeChunkPoJo mergeChunkPoJo = (MergeChunkPoJo) var1;
        String videoName = mergeChunkPoJo.getFileName();
        String videoType = mergeChunkPoJo.getFileType();
        String soreHouseUUID = (String) var2;
        String originPath = BuildPathUtils.buildPath();
        //首先计算视频时长

        // 缩略图+dash流

        //最后删除视频，只保留切片+mpd+缩略图.jpeg

        //最后将 相关数据存储数据库
        String buildDASHDate = simpleDateFormat.format(new Date());

    }



}
