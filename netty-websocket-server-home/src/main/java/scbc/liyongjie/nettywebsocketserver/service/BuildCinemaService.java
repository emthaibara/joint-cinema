package scbc.liyongjie.nettywebsocketserver.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserver.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserver.handler.WebSocketTextInboundHandler;
import scbc.liyongjie.nettywebsocketserver.message.CinemaInviteMessage;
import scbc.liyongjie.nettywebsocketserver.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketserver.util.RedisUtils;
import scbc.liyongjie.nettywebsocketserver.util.UUIDUtils;
import scbc.liyongjie.nettywebsocketserver.util.UserChannelMapUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 *              1.存储房间信息至redis
 *              2.通知其他成员进入
 */

@Service
public class BuildCinemaService {

    @Resource
    private RedisUtils redisUtils;

    public String build(BuildCinemaPoJo buildCinemaPoJo){

        String cinemaUUID = UUIDUtils.getUUID();
        List<String> member = buildCinemaPoJo.getMember();

        //通知
        for(String number : member){
            Channel channel = UserChannelMapUtil.getChannel(number);
            if (Objects.isNull(channel)){
                member.remove(number);      //离线则从房间去除
            }else {
                channel.writeAndFlush(new TextWebSocketFrame(JSON
                        .toJSONString(buildCinemaInviteMessage(cinemaUUID
                                ,buildCinemaPoJo.getHomeowner_nickname()
                                ,buildCinemaPoJo.getHomeowner_avatar()))));
            }
        }

        redisUtils.set(RedisKeyPrefixEnums.CINEMA.name()+cinemaUUID, JSON.toJSONString(buildCinemaPoJo));
        return cinemaUUID;
    }

    private CinemaInviteMessage buildCinemaInviteMessage(String cinemaUUID,String sender_nickname,String sender_avatar){
        CinemaInviteMessage cinemaInviteMessage = new CinemaInviteMessage();
        cinemaInviteMessage.setCinemaUUID(cinemaUUID);
        cinemaInviteMessage.setSender_avatar(sender_avatar);
        cinemaInviteMessage.setSender_nickname(sender_nickname);
        return cinemaInviteMessage;
    }

}
