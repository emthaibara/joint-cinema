package cn.scbc.servicevideouploadapi.handler;

import cn.scbc.servicevideouploadapi.exception.BasicException;
import cn.scbc.servicevideouploadapi.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.EOFException;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ResponseBody
    @ExceptionHandler(BasicException.class)
    public Result<String> basicException(BasicException e){
        return new Result<>(e.getMessage(),1010);
    }

    @ResponseBody
    @ExceptionHandler(EOFException.class)
    public void eOFException(EOFException e){
        log.info("管道意外的关闭，可能被暂停上传！");
    }



}
