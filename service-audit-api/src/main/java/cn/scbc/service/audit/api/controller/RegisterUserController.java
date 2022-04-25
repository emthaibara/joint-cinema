package cn.scbc.service.audit.api.controller;

import cn.scbc.service.audit.api.dao.UserMapper;
import cn.scbc.service.audit.api.po.User;
import cn.scbc.service.audit.api.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 */

@RestController
@CrossOrigin
public class RegisterUserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/audit/get/register/user")
    public Result<List<User>> getRegisterUser(){
        return new Result<>(userMapper.selectAll());
    }

    //todo  冻结 / 黑名单 / 白名单 / 通知 待完成
}
