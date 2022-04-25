package scbc.liyongjie.serviceavatarapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
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

    private static final Logger log = LoggerFactory.getLogger(AvatarController.class);

    @Resource
    private AvatarService avatarService;

    @PostMapping("/set/avatar/{number}")
    public Result<String> setNickName(@RequestParam("file")MultipartFile multipartFile,
                                      @PathVariable String number){
        log.info(number+"-----正在更改头像...");
        String newAvatarUrl = avatarService.avatar(number,multipartFile);
        return new Result<>(newAvatarUrl);
    }

}
