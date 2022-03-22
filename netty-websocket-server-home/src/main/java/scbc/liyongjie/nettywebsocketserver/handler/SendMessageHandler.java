package scbc.liyongjie.nettywebsocketserver.handler;

import io.netty.channel.Channel;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserver.message.*;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/26
 *
 */

@Service
public class SendMessageHandler {

    public void doBind(BindAskMessage message, Channel channel){
        UserChannelMapUtil.doBind(message.getNumber(),channel);
    }

}
