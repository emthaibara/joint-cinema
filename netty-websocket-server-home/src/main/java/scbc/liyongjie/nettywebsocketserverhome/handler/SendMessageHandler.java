package scbc.liyongjie.nettywebsocketserverhome.handler;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserverhome.message.BindAskMessage;
import scbc.liyongjie.nettywebsocketserverhome.util.UserChannelMapUtil;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 *
 */

@Service
public class SendMessageHandler {

    private static final Logger log = LoggerFactory.getLogger(SendMessageHandler.class);

    public void doBind(BindAskMessage message, Channel channel){
        log.info(message.toString());
        UserChannelMapUtil.doBind(message.getNumber(),channel);
    }

}
