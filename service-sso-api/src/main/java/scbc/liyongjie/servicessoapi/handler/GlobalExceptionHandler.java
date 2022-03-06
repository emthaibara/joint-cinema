package scbc.liyongjie.servicessoapi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import scbc.liyongjie.servicessoapi.enums.CodeMsgEnum;
import scbc.liyongjie.servicessoapi.exception.BaseException;
import scbc.liyongjie.servicessoapi.exception.LoginException;
import scbc.liyongjie.servicessoapi.result.Result;


/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Result<?> remoteExceptionHandler(BaseException e) {
        log.error(e.getMessage());
        return new Result<>().error(e.getMessage(),null);
    }

    @ResponseBody
    @ExceptionHandler(value = LoginException.class)
    public Result<?> loginExceptionHandler(){
        log.error(CodeMsgEnum.NOTEXIST.getCodeMsg());
        return new Result<>().error(CodeMsgEnum.NOTEXIST);
    }

}
