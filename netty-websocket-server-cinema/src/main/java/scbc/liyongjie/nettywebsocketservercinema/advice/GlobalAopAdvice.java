package scbc.liyongjie.nettywebsocketservercinema.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import scbc.liyongjie.nettywebsocketservercinema.util.UserChannelMapUtil;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@Component
@Aspect
public class GlobalAopAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobalAopAdvice.class);



    @After("scbc.liyongjie.nettywebsocketservercinema.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void printLog(){
        log.info(UserChannelMapUtil
                .getClient()
                .entrySet()
                .toString());
    }

    @Before("scbc.liyongjie.nettywebsocketservercinema.aspect.CommonAspect.socketClient()")
    public void printClientJsonDataLog(){

    }

}
