package scbc.liyongjie.nettywebsocketserver.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scbc.liyongjie.nettywebsocketserver.enums.CodeMsgEnum;
import scbc.liyongjie.nettywebsocketserver.exception.FriendNotExistException;
import scbc.liyongjie.nettywebsocketserver.exception.FriendRepeatException;
import scbc.liyongjie.nettywebsocketserver.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = FriendRepeatException.class)
    public Result<?> friendsRepeatException(){
        return new Result<>(CodeMsgEnum.FRIEND_REPEAT);
    }

    @ExceptionHandler(value = FriendNotExistException.class)
    public Result<?> friendNotExistException(){
        return new Result<>(CodeMsgEnum.FRIEND_NOT_EXIST);
    }



}
