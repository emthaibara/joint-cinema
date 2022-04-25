package scbc.liyongjie.nettywebsocketservercinema.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import scbc.liyongjie.nettywebsocketservercinema.util.RedisUtils;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 *
 */

@Service
public class RefreshMemberService {

    @Resource
    private RedisUtils redisUtils;

    @Async
    public void refreshMember(String cinemaUUID,String offlineUser){

    }

}
