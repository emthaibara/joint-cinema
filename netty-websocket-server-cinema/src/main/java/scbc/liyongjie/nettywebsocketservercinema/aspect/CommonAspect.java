package scbc.liyongjie.nettywebsocketservercinema.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@Component
@Aspect
public class CommonAspect {

    @Pointcut("execution(* scbc.liyongjie.nettywebsocketservercinema.handler.SendMessageHandler.*(..))")
    public void sendMessageHandlerAspect(){}

}
