package scbc.liyongjie.servicevideoapi.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scbc.liyongjie.servicevideoapi.enums.CodeMsgEnum;
import scbc.liyongjie.servicevideoapi.exception.ShareRepeatException;
import scbc.liyongjie.servicevideoapi.exception.UnRegisteredException;
import scbc.liyongjie.servicevideoapi.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/28
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ShareRepeatException.class)
    public Result<?> shareRepeatExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.SHARE_REPEAT);
    }

    @ResponseBody
    @ExceptionHandler(value = UnRegisteredException.class)
    public Result<?> unRegisteredExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.NOTEXIST);
    }
}
