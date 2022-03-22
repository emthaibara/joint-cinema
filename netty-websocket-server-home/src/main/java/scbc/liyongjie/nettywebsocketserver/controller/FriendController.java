package scbc.liyongjie.nettywebsocketserver.controller;

import org.springframework.web.bind.annotation.*;
import scbc.liyongjie.nettywebsocketserver.message.FriendApplyMessage;
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

    /**
     *  获取离线好友列表
     * @param number   手机号
     * @return  result
     *
     */
    @GetMapping("/get/offline/friend/")
    public Result<List<FriendPoJo>> getOfflineFriend(@RequestParam(value = "number")String number){
        List<FriendPoJo> friendPoJoList = friendService.getOfflineFriend(number);
        return new Result<>(friendPoJoList);
    }

    /**
     *  获取在线好友列表
     * @param number 手机号
     * @return  result
     */
    @GetMapping("/get/online/friend/")
    public Result<List<FriendPoJo>> getOnlineFriend(@RequestParam(value = "number")String number){
        List<FriendPoJo> friendPoJoList = friendService.getOnlineFriend(number);
        return new Result<>(friendPoJoList);
    }

    /**
     *  删除好友
     * @param number    手机号
     * @param deleteFriend     删除好友电话号码
     * @return result
     */
    @DeleteMapping("/delete/friend/")       //暂时不使用
    public Result<String> deleteFriend(@RequestParam(value = "number")String number,
                                       @RequestParam(value = "delete")String deleteFriend){
        friendService.delete(number,deleteFriend);
        return new Result<>("delete success!");
    }

    /**
     *  添加好友
     * @param number    手机号
     * @param addFriend 待添加好友手机号
     * @return  result
     */
    @PutMapping("/add/friend/")
    public Result<String> addFriend(@RequestParam(value = "number")String number,
                                    @RequestParam(value = "add")String addFriend){
        friendService.add(number,addFriend);
        return new Result<>("add success!");
    }

    /**
     *      发送好友申请
     * @param senderUsername  用户昵称
     * @param senderAvatar    申请方头像
     * @param senderNumber    申请人手机号
     * @param receiver    接收好友申请消息方
     * @return  result
     */
    @RequestMapping("/friend/apply/")
    public Result<String> friendApply(@RequestParam(value = "sender_username")String senderUsername,
                                      @RequestParam(value = "sender_avatar")String senderAvatar,
                                      @RequestParam(value = "sender_number")String senderNumber,
                                      @RequestParam(value = "receiver")String receiver){
        friendApplyService.friendApply(senderUsername,senderAvatar,senderNumber,receiver);
        return new Result<>("friend apply send success !");
    }

    /**
     *  获取待处理的好友申请消息列表
     * @param number   手机号
     * @return  返回待处理的好友申请
     */
    @GetMapping("/get/friend/apply/cache/")
    public Result<List<FriendApplyMessage>> getFriendApplyMessage(@RequestParam(value = "number")String number){
        List<FriendApplyMessage> friendApplyMessageList = friendApplyService.getFriendApplyMessageCache(number);
        return new Result<>(friendApplyMessageList);
    }

}
