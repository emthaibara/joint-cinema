package scbc.liyongjie.nettywebsocketservercinema.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scbc.liyongjie.nettywebsocketservercinema.enums.CodeMsgEnum;
import scbc.liyongjie.nettywebsocketservercinema.exception.CinemaNotExistException;
import scbc.liyongjie.nettywebsocketservercinema.exception.NotCinemaMemberException;
import scbc.liyongjie.nettywebsocketservercinema.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/20
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = CinemaNotExistException.class)
    public Result<String> cinemaNotExistExceptionHandler(){
        return new Result<String>().error(CodeMsgEnum.CINEMA_NOT_EXIST);
    }

    @ResponseBody
    @ExceptionHandler(value = NotCinemaMemberException.class)
    public Result<String> notCinemaMemberExceptionHandler(){
        return new Result<String>().error(CodeMsgEnum.NOT_CINEMA_MEMBER);
    }
}
