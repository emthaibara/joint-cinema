package scbc.liyongjie.nettywebsocketserverhome.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import scbc.liyongjie.nettywebsocketserverhome.util.UserChannelMapUtil;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 *          所有的消息过滤在GlobalAopAdvice做aop处理
 *          用于验证身份和合法性
 */

@Aspect
@Component
public class GlobalAopAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobalAopAdvice.class);

    @After("scbc.liyongjie.nettywebsocketserverhome.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void printLog(){
        log.info("============channel映射更新==========");
        log.info(UserChannelMapUtil
                .getClient()
                .entrySet()
                .toString());
        log.info("============channel映射更新==========");
    }


}
