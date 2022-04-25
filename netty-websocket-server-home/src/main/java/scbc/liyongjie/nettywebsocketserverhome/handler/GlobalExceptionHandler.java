package scbc.liyongjie.nettywebsocketserverhome.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scbc.liyongjie.nettywebsocketserverhome.enums.CodeMsgEnum;
import scbc.liyongjie.nettywebsocketserverhome.exception.FriendNotExistException;
import scbc.liyongjie.nettywebsocketserverhome.exception.FriendRepeatException;
import scbc.liyongjie.nettywebsocketserverhome.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/15
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = FriendRepeatException.class)
    public Result<?> friendsRepeatException(){
        return new Result<>().error(CodeMsgEnum.FRIEND_REPEAT);
    }

    @ExceptionHandler(value = FriendNotExistException.class)
    public Result<?> friendNotExistException(){
        return new Result<>().error(CodeMsgEnum.FRIEND_NOT_EXIST);
    }

}
