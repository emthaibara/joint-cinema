package cn.scbc.service.audit.api.controller;

import cn.scbc.service.audit.api.dao.VideoMapper;
import cn.scbc.service.audit.api.po.Video;
import cn.scbc.service.audit.api.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/17
 */

@RestController
public class AuditPassVideoController {

    @Resource
    private VideoMapper videoMapper;

    @GetMapping("/get/all/passVideos")
    public Result<List<Video>> getAuditPassVideos(){
        return new Result<>(videoMapper.selectAll());
    }

}
