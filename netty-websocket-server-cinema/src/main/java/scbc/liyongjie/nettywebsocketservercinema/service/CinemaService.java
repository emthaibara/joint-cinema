package scbc.liyongjie.nettywebsocketservercinema.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketservercinema.enums.RedisKeyPrefixEnums;
import scbc.liyongjie.nettywebsocketservercinema.exception.CinemaNotExistException;
import scbc.liyongjie.nettywebsocketservercinema.pojo.BuildCinemaPoJo;
import scbc.liyongjie.nettywebsocketservercinema.util.RedisUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@Service
public class CinemaService {

    @Resource
    private RedisUtils redisUtils;

    public BuildCinemaPoJo getCinemaInitData(String cinemaUUID) {
        String json = redisUtils.get(RedisKeyPrefixEnums.CINEMA+cinemaUUID);

        if (Objects.isNull(json))
            throw new CinemaNotExistException();

        return JSON.parseObject(json,BuildCinemaPoJo.class);
    }




}
