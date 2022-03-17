package scbc.liyongjie.nettywebsocketserver.controller;

import org.springframework.web.bind.annotation.*;
import scbc.liyongjie.nettywebsocketserver.message.apply.FriendApplyMessage;
import scbc.liyongjie.nettywebsocketserver.pojo.FriendPoJo;
import scbc.liyongjie.nettywebsocketserver.result.Result;
import scbc.liyongjie.nettywebsocketserver.service.FriendApplyService;
import scbc.liyongjie.nettywebsocketserver.service.FriendService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 *
 *      所有请求在网关统一验证身份
 *          除了特殊需求不需要经过网关路由请求
 */

@RestController
public class FriendController {

    @Resource
    private FriendService friendService;
    
    @Resource
    private FriendApplyService friendApplyService;
    
    @GetMapping("/get/offline/friend/")
    public Result<List<FriendPoJo>> getOfflineFriend(@RequestParam(value = "number")String number){
        List<FriendPoJo> friendPoJoList = friendService.getOfflineFriend(number);
        return new Result<>(friendPoJoList);
    }

    @GetMapping("/get/online/friend/")
    public Result<List<FriendPoJo>> getOnlineFriend(@RequestParam(value = "number")String number){
        List<FriendPoJo> friendPoJoList = friendService.getOnlineFriend(number);
        return new Result<>(friendPoJoList);
    }

    @DeleteMapping("/delete/friend/")
    public Result<String> deleteFriend(@RequestParam(value = "number")String number,
                                       @RequestParam(value = "delete")String deleteFriend){
        friendService.delete(number,deleteFriend);
        return new Result<>("delete success!");
    }

    @PutMapping("/add/friend/")
    public Result<String> addFriend(@RequestParam(value = "number")String number,
                                    @RequestParam(value = "add")String addFriend){
        friendService.add(number,addFriend);
        return new Result<>("add success!");
    }
    
    @RequestMapping("/friend/apply/")
    public Result<String> friendApply(@RequestParam(value = "username")String username,
                                      @RequestParam(value = "sender")String sender,
                                      @RequestParam(value = "number")String number){
        friendApplyService.friendApply(username,sender,number);
        return new Result<>("friend apply send success !");
    }

    @GetMapping("/check/friend/apply/")
    public Result<List<FriendApplyMessage>> getFriendApplyMessage(@RequestParam(value = "number")String number){
        List<FriendApplyMessage> friendApplyMessageList = friendApplyService.getFriendApplyMessageCache(number);
        return new Result<>(friendApplyMessageList);
    }

}
