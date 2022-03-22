package scbc.liyongjie.servicenicknameapi.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scbc.liyongjie.servicenicknameapi.enums.CodeMsgEnum;
import scbc.liyongjie.servicenicknameapi.exception.NickNameException;
import scbc.liyongjie.servicenicknameapi.exception.UnRegisterException;
import scbc.liyongjie.servicenicknameapi.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/23
 */

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(NickNameException.class)
    public Result<?> nickNameExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.VIOLATION_NICK_NAME);
    }

    @ResponseBody
    @ExceptionHandler(UnRegisterException.class)
    public Result<?> unRegisterExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.UN_REGISTER);
    }

}
