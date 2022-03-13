package scbc.liyongjie.nettywebsocketserver.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

@Component
@Aspect
public class CommonAspect {

    @Pointcut("execution(* scbc.liyongjie.nettywebsocketserver.handler.SendMessageHandler.*(..))")
    public void sendMessageHandlerAspect(){}

}
