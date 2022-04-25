package cn.scbc.service.audit.api.service;

import cn.scbc.service.audit.api.dao.UserMapper;
import cn.scbc.service.audit.api.dao.VideoAuditMapper;
import cn.scbc.service.audit.api.message.BuildDashMessage;
import cn.scbc.service.audit.api.po.VideoAudit;
import cn.scbc.service.audit.api.pojo.AuditVideoPoJo;
import cn.scbc.service.audit.api.pojo.UnderReviewVideo;
import cn.scbc.service.audit.api.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/15
 */

@Service
public class AuditVideoService {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private VideoAuditMapper videoAuditMapper;

    @Resource
    private UserMapper userMapper;

    private static final String REDIS_KEY = "AUDIT_VIDEO";

    public List<AuditVideoPoJo> getAuditVideo(){
        List<AuditVideoPoJo> auditVideoPoJos = new ArrayList<>();
        for (VideoAudit videoAudit : videoAuditMapper.selectAll()) {
            String uuid = videoAudit.getUuid();
            String status = videoAudit.getStatus();
            if (status.equals("0")){
                String json = redisUtils.get(REDIS_KEY+uuid);
                UnderReviewVideo underReviewVideo = JSON.parseObject(json,UnderReviewVideo.class);
                String duration = underReviewVideo.getDuration();
                String fileName = underReviewVideo.getFileName();
                String fileSize = underReviewVideo.getFileSize();
                String number = underReviewVideo.getNumber();
                String thumbnailPath = underReviewVideo.getThumbnailPath();
                String uploadDate = underReviewVideo.getUploadDate();
                AuditVideoPoJo auditVideoPoJo = new AuditVideoPoJo();
                auditVideoPoJo.setUuid(uuid);
                auditVideoPoJo.setThumbnail(thumbnailPath);
                auditVideoPoJo.setNumber(number);
                auditVideoPoJo.setNickname(userMapper.selectByPrimaryKey(number).getName());
                auditVideoPoJo.setDuration(duration);
                auditVideoPoJo.setSize(fileSize);
                auditVideoPoJo.setUploadDate(uploadDate);
                auditVideoPoJo.setVideoName(fileName);
                auditVideoPoJo.setVideoUrl(underReviewVideo.getAuditVideoAccessPath());
                auditVideoPoJos.add(auditVideoPoJo);
            }
        }
        return auditVideoPoJos;
    }

    public void auditPass(String uuid){
        String json = redisUtils.get(REDIS_KEY+uuid);
        UnderReviewVideo underReviewVideo = JSON.parseObject(json,UnderReviewVideo.class);
        String originPath = underReviewVideo.getOriginPath();
        String buildDashPath = underReviewVideo.getBuildDashPath();
        BuildDashMessage buildDashMessage = new BuildDashMessage();
        buildDashMessage.setUuid(uuid);
        buildDashMessage.setOriginPath(originPath);
        buildDashMessage.setBuildDashPath(buildDashPath);
        VideoAudit videoAudit = new VideoAudit();
        videoAudit.setNumber(underReviewVideo.getNumber());
        videoAudit.setUuid(uuid);
        videoAudit.setStatus("1");
        videoAuditMapper.updateByPrimaryKey(videoAudit);
        kafkaTemplate.send("build_dash",JSON.toJSONString(buildDashMessage));
    }

    public void auditFail(String uuid){

        String json = redisUtils.get(REDIS_KEY+uuid);
        UnderReviewVideo underReviewVideo = JSON.parseObject(json,UnderReviewVideo.class);

        VideoAudit videoAudit = new VideoAudit();
        videoAudit.setNumber(underReviewVideo.getNumber());
        videoAudit.setUuid(uuid);
        videoAudit.setStatus("-1");

        videoAuditMapper.updateByPrimaryKey(videoAudit);

    }

}
