package scbc.liyongjie.nettywebsocketserverhome.aspect;

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

    @Pointcut("execution(* scbc.liyongjie.nettywebsocketserverhome.handler.SendMessageHandler.*(..))")
    public void sendMessageHandlerAspect(){}

}
