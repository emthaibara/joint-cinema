package cn.scbc.service.audit.api.controller;

import cn.scbc.service.audit.api.pojo.AuditVideoPoJo;
import cn.scbc.service.audit.api.result.Result;
import cn.scbc.service.audit.api.service.AuditVideoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 *
 */

@RestController
public class PendingReviewVideoController {

    @Resource
    private AuditVideoService auditVideoService;

    @GetMapping("/audit/get/check/videos")
    public Result<List<AuditVideoPoJo>> getCheckVideos(){
        List<AuditVideoPoJo> auditVideoPoJos = auditVideoService.getAuditVideo();
        return new Result<>(auditVideoPoJos);
    }

    @DeleteMapping("/audit/video/pass")
    public Result<String> passVideo(@RequestParam(value = "uuid")String videoUUID){
        auditVideoService.auditPass(videoUUID);
        return new Result<>();
    }

    @DeleteMapping("/audit/video/fail")
    public Result<String> failVideo(@RequestParam(value = "uuid")String videoUUID){
        auditVideoService.auditFail(videoUUID);
        return new Result<>();
    }

}
