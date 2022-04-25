package cn.scbc.servicevideouploadapi.controller;

import cn.scbc.servicevideouploadapi.pojo.SecondPassPoJo;
import cn.scbc.servicevideouploadapi.result.Result;
import cn.scbc.servicevideouploadapi.service.SecondPassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 *
 */

@RestController
public class SecondPassController {

    private static final Logger log = LoggerFactory.getLogger(SecondPassController.class);

    @Resource
    private SecondPassService secondPassService;

    @PostMapping("/isSecondPass/{storeHouseUUID}")
    public Boolean isSecondPass(SecondPassPoJo secondPassPoJo,
                                        @PathVariable String storeHouseUUID){
        log.info("md5----{}----storeHouseUUID---{}",secondPassPoJo.toString(),storeHouseUUID);
        return secondPassService.isSecondPass(storeHouseUUID,secondPassPoJo);
    }

}
