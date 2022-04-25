package scbc.liyongjie.serviceavatarapi.handler;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scbc.liyongjie.serviceavatarapi.enums.CodeMsgEnum;
import scbc.liyongjie.serviceavatarapi.exception.*;
import scbc.liyongjie.serviceavatarapi.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/23
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = AvatarTypeException.class)
    public Result<?> avatarTypeExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.AVATAR_TYPE_VIOLATION);
    }

    @ResponseBody
    @ExceptionHandler(value = NotDataException.class)
    public Result<?> notDataExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.NOT_DATA);
    }

    @ResponseBody
    @ExceptionHandler(value = OverSizeAvatarException.class)
    public Result<?> overSizeAvatarExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.OVER_SIZE);
    }

    @ResponseBody
    @ExceptionHandler(value = UnRegisterException.class)
    public Result<?> unRegisterExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.UN_REGISTER);
    }

    @ResponseBody
    @ExceptionHandler(value = UploadFailException.class)
    public Result<?> uploadFailExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.UPLOAD_FAIL);
    }

    @ResponseBody
    @ExceptionHandler(value = FileSizeLimitExceededException.class)
    public Result<?> fileSizeLimitExceededExceptionHandler(){
        return new Result<>().error(CodeMsgEnum.OVER_SIZE);
    }

}
