package scbc.liyongjie.servicevideoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scbc.liyongjie.servicevideoapi.pojo.UnderReviewVideoPoJo;
import scbc.liyongjie.servicevideoapi.result.Result;
import scbc.liyongjie.servicevideoapi.service.VideoAuditService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/18
 */

@RestController
public class VideoAuditController {

    @Resource
    private VideoAuditService videoAuditService;

    @GetMapping("/get/UnderReviewVideos")
    public Result<List<UnderReviewVideoPoJo>> getUnderReviewVideoPoJos(@RequestParam(value = "number") String number){
        List<UnderReviewVideoPoJo> underReviewVideoPoJos = videoAuditService.getUnderReviewVideoPoJos(number);
        return new Result<>(underReviewVideoPoJos);
    }

}
