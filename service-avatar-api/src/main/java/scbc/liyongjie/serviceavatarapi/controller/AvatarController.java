package scbc.liyongjie.serviceavatarapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import scbc.liyongjie.serviceavatarapi.result.Result;
import scbc.liyongjie.serviceavatarapi.service.AvatarService;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */

@RestController
public class AvatarController {

    @Resource
    private AvatarService avatarService;

    @GetMapping("/set/avatar/")
    public Result<String> setNickName(@RequestParam(value = "number")String number,
                                      MultipartFile newAvatar){
        String newAvatarUrl = avatarService.avatar(number,newAvatar);
        return new Result<>(newAvatarUrl);
    }

}
