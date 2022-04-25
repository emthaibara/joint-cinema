package scbc.liyongjie.servicelogoutapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import scbc.liyongjie.servicelogoutapi.enums.PrefixEnum;
import scbc.liyongjie.servicelogoutapi.result.Result;
import scbc.liyongjie.servicelogoutapi.service.LogoutService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/7
 */

@RestController
public class LogoutController {

    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

    @Resource
    private LogoutService logoutService;

    @PostMapping("/logout")
    public Result<?> logout(HttpServletRequest request){
        log.info("logout--token---[{}]",request.getHeader(PrefixEnum.TOKEN.getPrefix()));
        logoutService.logout(request.getHeader(PrefixEnum.TOKEN.getPrefix()));
        return new Result<>().logoutSuccess();
    }

}
