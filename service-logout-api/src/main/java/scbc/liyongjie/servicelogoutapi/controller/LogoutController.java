package scbc.liyongjie.servicelogoutapi.controller;

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

    @Resource
    private LogoutService logoutService;

    @PostMapping("/logout")
    public Result<?> logout(HttpServletRequest request){
        logoutService.logout(request.getHeader(PrefixEnum.TOKEN.getPrefix()));
        return new Result<>().logoutSuccess();
    }

}
