package scbc.liyongjie.nettywebsocketserver.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import scbc.liyongjie.nettywebsocketserver.message.AbstractMessage;
import scbc.liyongjie.nettywebsocketserver.util.JwtUtil;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

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

    @Before("scbc.liyongjie.nettywebsocketserver.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void checkToken(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object message = args[0];
        AbstractMessage abstractMessage = (AbstractMessage) message;
        String token = abstractMessage.getToken();
        if (!verifyJwtToken(abstractMessage.getToken()))
            throw new RuntimeException("jwt token verify fail");

        log.info("有新的合法消息，token：{}",token);
        log.info(UserChannelMapUtil
                .getClient()
                .entrySet()
                .toString());
    }

    @After("scbc.liyongjie.nettywebsocketserver.aspect.CommonAspect.sendMessageHandlerAspect()")
    public void printLog(){
        log.info(UserChannelMapUtil
                .getClient()
                .entrySet()
                .toString());
    }

    private Boolean verifyJwtToken(String jwt){
        return JwtUtil.verify(jwt);
    }

}
