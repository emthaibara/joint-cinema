package scbc.liyongjie.servicessoapi.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicessoapi.pojo.UserPoJo;
import scbc.liyongjie.servicessoapi.result.Result;
import scbc.liyongjie.servicessoapi.service.SsoService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */

@RestController
@CrossOrigin
public class SsoController {

    @Resource
    private SsoService ssoService;

    @PostMapping("/mycinema/sso")
    public Result<?> sso(@RequestBody @Validated UserPoJo userPoJo){
        ssoService.sso(userPoJo);
        return Result.loginSuccess();
    }

}
