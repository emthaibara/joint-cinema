package scbc.liyongjie.nettywebsocketserverhome.service;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketserverhome.enums.MessageTypeEnum;
import scbc.liyongjie.nettywebsocketserverhome.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketserverhome.message.CinemaApplyMessage;
import scbc.liyongjie.nettywebsocketserverhome.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketserverhome.util.RedisUtils;
import scbc.liyongjie.nettywebsocketserverhome.util.UUIDUtils;
import scbc.liyongjie.nettywebsocketserverhome.util.UserChannelMapUtil;

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

    public void build(BuildCinemaPoJo buildCinemaPoJo){
        String cinemaUUID = UUIDUtils.getUUID();
        List<String> member = buildCinemaPoJo.getMember();

        //通知
        for(String number : member){
            Channel channel = UserChannelMapUtil.getChannel(number);
            if (Objects.isNull(channel)){
                buildCinemaPoJo.getMember().remove(number);      //离线则从房间去除
            }else {
                channel.writeAndFlush(new TextWebSocketFrame(JSON
                        .toJSONString(buildCinemaApplyMessage(
                                buildCinemaPoJo.getHomeowner_nickname() //发起人---房主昵称
                                ,buildCinemaPoJo.getHomeowner_avatar()  //发起人---房主头像
                                ,buildCinemaPoJo.getVideoName()
                                ,buildCinemaPoJo.getThumbnail()))));    //影片名称
                //将成员----房间号的映射存入redis，在进入房间的时候再向后台索取房间号，再获取房间基本信息
                redisUtils.set(RedisKeyPrefixEnums.CINEMA+number,cinemaUUID);
            }
        }
        redisUtils.set(RedisKeyPrefixEnums.CINEMA+buildCinemaPoJo.getHomeowner_number(),cinemaUUID);
        //进入房间拿到cinema uuid后携带房间uuid获取房间的初始化数据
        redisUtils.set(RedisKeyPrefixEnums.CINEMA.name()+cinemaUUID, JSON.toJSONString(buildCinemaPoJo));
    }

    private CinemaApplyMessage buildCinemaApplyMessage(String sender_nickname, String sender_avatar,String videoName,String videoThumbnail){
        CinemaApplyMessage cinemaApplyMessage = new CinemaApplyMessage();
        cinemaApplyMessage.setType(MessageTypeEnum.CINEMA_LAUNCH.getType());
        cinemaApplyMessage.setSender_avatar(sender_avatar);
        cinemaApplyMessage.setSender_nickname(sender_nickname);
        cinemaApplyMessage.setVideoName(videoName);
        cinemaApplyMessage.setVideoThumbnail(videoThumbnail);

        return cinemaApplyMessage;
    }

}
