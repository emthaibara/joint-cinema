package scbc.liyongjie.servicesignapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicesignapi.pojo.UserPoJo;
import scbc.liyongjie.servicesignapi.result.Result;
import scbc.liyongjie.servicesignapi.service.SignService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */

@RestController
@CrossOrigin
public class SignController {

    private final Logger log = LoggerFactory.getLogger(SignController.class);

    @Resource
    private SignService loginService;

    @PostMapping("/mycinema/sign")
    public Result<?> sign(@RequestBody
                              @Validated UserPoJo userPoJo){

        log.info("有新的注册用户到来-----{}",userPoJo.toString());
        Integer result = loginService.login(userPoJo);
        log.info("新增注册用户--number:{}----{}",userPoJo.getNumber(),result);

        return Result.signSuccess();
    }

}

