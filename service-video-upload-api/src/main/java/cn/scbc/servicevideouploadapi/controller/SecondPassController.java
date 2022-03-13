package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.result.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 *
 */

@RestController
public class SecondPassController {

    @PostMapping("/isSecondPass/{storeHouseUUID}")
    public Result<Boolean> isSecondPass(SecondPassPoJo secondPassPoJo,
                                        @PathVariable String storeHouseUUID){
        //Boolean result = secondPassService.isSecondPass(secondPassPoJo.getFileMd5());
        return new Result<>(Boolean.FALSE);
    }

}
