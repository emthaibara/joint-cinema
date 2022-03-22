package scbc.liyongjie.servicessoapi.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicessoapi.pojo.SsoPoJo;
import scbc.liyongjie.servicessoapi.pojo.UserPoJo;
import scbc.liyongjie.servicessoapi.result.Result;
import scbc.liyongjie.servicessoapi.service.SsoService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */

@RestController
@CrossOrigin    //局部跨域设置
public class SsoController {

    @Resource
    private SsoService ssoService;

    /**
     * sso对外暴露接口
     * @param ssoPoJo  post请求body中json--->实体PoJo
     * @return  返回包装实体
     */
    @PostMapping("/mycinema/sso")
    public Result<UserPoJo> sso(@RequestBody   //Validated自定义校验实体UserPoJo
                             @Validated SsoPoJo ssoPoJo){
        UserPoJo userPoJo = ssoService.sso(ssoPoJo);
        return new Result<>(userPoJo);
    }

}
