package scbc.liyongjie.serviceffmpegapi.consumer;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import scbc.liyongjie.serviceffmpegapi.dao.VideoAuditMapper;
import scbc.liyongjie.serviceffmpegapi.dao.VideoMapper;
import scbc.liyongjie.serviceffmpegapi.message.BuildDashMessage;
import scbc.liyongjie.serviceffmpegapi.po.Video;
import scbc.liyongjie.serviceffmpegapi.po.VideoAudit;
import scbc.liyongjie.serviceffmpegapi.pojo.UnderReviewVideo;
import scbc.liyongjie.serviceffmpegapi.service.CommandExecuteService;
import scbc.liyongjie.serviceffmpegapi.util.RedisUtils;

import javax.annotation.Resource;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/17
 */

@Component
public class BuildDashMessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(BuildDashMessageConsumer.class);

    @Resource
    private CommandExecuteService commandExecuteService;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private VideoAuditMapper videoAuditMapper;

    @Resource
    private VideoMapper videoMapper;

    //private static final String LOCAL = "/Users/lemt/Desktop/scbc.liyongjie/scbc.static";
    private static final String LOCAL = "/root";

    private static final String REDIS_KEY = "AUDIT_VIDEO";
    private static final String STATUS = "2";   //审核通过，视频流生成完毕

    @KafkaListener(topics = "build_dash")
    public void onMessage(String message){

        BuildDashMessage buildDashMessage = JSON.parseObject(message,BuildDashMessage.class);
        String uuid = buildDashMessage.getUuid();
        String originPath = buildDashMessage.getOriginPath();
        String accessDashPath = buildDashMessage.getBuildDashPath();
        String targetPath = LOCAL+accessDashPath;

        //build dash
        commandExecuteService.ffmpegBuildDASH(originPath,targetPath);

        //获取视频的暂存数据
        UnderReviewVideo underReviewVideo = JSON.parseObject(redisUtils.get(REDIS_KEY+uuid),UnderReviewVideo.class);

        //存储数据库
        db(uuid,
                underReviewVideo.getUploadDate(),
                underReviewVideo.getFileType(),
                underReviewVideo.getDuration(),
                accessDashPath,
                underReviewVideo.getFileSize(),
                underReviewVideo.getThumbnailPath(),
                underReviewVideo.getStoreHouseUUID(),
                underReviewVideo.getFileMd5(),
                underReviewVideo.getFileName());

        //更改审核状态
        updateAuditStatus(uuid,underReviewVideo.getNumber());
    }

    private void db(String uuid,
                    String date,
                    String type,
                    String duration,
                    String url,
                    String size,
                    String thumbnail,
                    String storehouse,
                    String md5,
                    String name){
        Video video = new Video();
        video.setUuid(uuid);
        video.setDate(date);
        video.setType(type);
        video.setDuration(duration);
        video.setUrl(url);
        video.setSize(size);
        video.setThumbnail(thumbnail);
        video.setStorehouse(storehouse);
        video.setMd5(md5);
        video.setName(name);
        videoMapper.insert(video);
        log.info("有新的视频审核通过-----并插入数据库---[{}]",video);
    }

    private void updateAuditStatus(String uuid, String number){
        VideoAudit videoAudit = new VideoAudit();
        videoAudit.setUuid(uuid);
        videoAudit.setNumber(number);
        videoAudit.setStatus(BuildDashMessageConsumer.STATUS);
        videoAuditMapper.updateByPrimaryKey(videoAudit);
        log.info("有新的视频审核通过-----并更新状态字段---[{}]",videoAudit);
    }

}
