package scbc.liyongjie.servicenicknameapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicenicknameapi.aspect.NickNameValidateAop;
import scbc.liyongjie.servicenicknameapi.result.Result;
import scbc.liyongjie.servicenicknameapi.service.NickNameService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 *    add_header 'Access-Control-Allow-Origin' '*';
 *    add_header 'Access-Control-Allow-Headers' '*';
 *    add_header 'Access-Control-Allow-Methods' '*';
 */
@RestController
public class NickNameController {

    @Resource
    private NickNameService nickNameService;

    @NickNameValidateAop
    @GetMapping("/set/nickname/")
    public Result<String> setNickName(@RequestParam(value = "new_nickname")String newNickName,
                                      @RequestParam(value = "number")String number){
        nickNameService.seyNickName(newNickName,number);
        return new Result<>("set nickname success!");
    }

}
