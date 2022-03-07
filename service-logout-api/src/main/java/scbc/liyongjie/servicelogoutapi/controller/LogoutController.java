package scbc.liyongjie.servicelogoutapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicelogoutapi.result.Result;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/7
 */

@RestController
@CrossOrigin
public class LogoutController {

    @PostMapping("/mycinema/logout/{token}")
    public Result<?> logout(@PathVariable String token){

        return new Result<>();
    }
}
