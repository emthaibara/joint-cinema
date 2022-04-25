package cn.scbc.servicevideouploadapi.service;

import cn.scbc.servicevideouploadapi.dao.VideoAuditMapper;
import cn.scbc.servicevideouploadapi.exception.BuildChunkFolderException;
import cn.scbc.servicevideouploadapi.grpc.FFmpegServiceConsumerGrpc;
import cn.scbc.servicevideouploadapi.po.VideoAudit;
import cn.scbc.servicevideouploadapi.pojo.MergeChunkPoJo;
import cn.scbc.servicevideouploadapi.pojo.UnderReviewVideo;
import cn.scbc.servicevideouploadapi.utils.BuildPathUtils;
import cn.scbc.servicevideouploadapi.utils.FilesUtils;
import cn.scbc.servicevideouploadapi.utils.RedisUtils;
import cn.scbc.servicevideouploadapi.utils.UUIDUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/10
 */

@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class FFmpegService {

    @Resource
    private FFmpegServiceConsumerGrpc fFmpegServiceConsumerGrpc;

    @Resource
    private VideoAuditMapper videoAuditMapper;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private SimpleDateFormat simpleDateFormat;

    @Value("${upload.storePath}")
    private String local;

    @Value("${upload.video.access.url}")
    private String accessPrefix;

    /**
     * 视频暂存redis数据的Key 前缀
     */
    private static final String REDIS_KEY = "AUDIT_VIDEO";

    /**
     * 审核中状态
     */
    private static final String STATUS = "0";

    public void ffmpegServiceAdvice(MergeChunkPoJo mergeChunkPoJo,String soreHouseUUID){

        String videoType = mergeChunkPoJo.getFileType();

        //视频唯一标识uuid
        String videoUUID = UUIDUtils.getUUID();

        //生成访问路径
        String accessOriginPath = BuildPathUtils.buildPath(accessPrefix,soreHouseUUID,"/",mergeChunkPoJo.getFileMd5(),videoType);
        String accessDashFolderPath =  BuildPathUtils.buildPath(accessPrefix,soreHouseUUID,"/",videoUUID,"/");
        String accessThumbnailPath = BuildPathUtils.buildPath(accessPrefix,soreHouseUUID,"/",videoUUID,"/",videoUUID,".jpeg");
        String accessMpdPath = BuildPathUtils.buildPath(accessPrefix,soreHouseUUID,"/",videoUUID,"/",videoUUID,".mpd");
        String accessAuditVideoUrl = BuildPathUtils.buildPath(accessPrefix,soreHouseUUID,"/",mergeChunkPoJo.getFileMd5(),mergeChunkPoJo.getFileType());

        //生成本地全路径
        String localOriginPath = BuildPathUtils.buildPath(local,accessOriginPath);
        String localDashFolderPath = BuildPathUtils.buildPath(local,accessDashFolderPath);
        String localThumbnailPath = BuildPathUtils.buildPath(local,accessThumbnailPath);

        Path mpdFolder = FilesUtils.creatFolder(localDashFolderPath);

        if (Objects.isNull(mpdFolder))
            throw new BuildChunkFolderException();

        // gRPC调用 thumbnail/preview 生成提供者接口
        fFmpegServiceConsumerGrpc.buildThumbnailGrpc(localOriginPath,localThumbnailPath);

        // gRPC调用video duration计算提供者接口
        String duration = fFmpegServiceConsumerGrpc.calculateDuration(localOriginPath);

        VideoAudit videoAudit = new VideoAudit();
        videoAudit.setNumber(mergeChunkPoJo.getNumber());
        videoAudit.setStatus(STATUS);  //审核状态 0 ------- pass 1 ------ fail -1 ----- dash build loading ... 2 ----- dash build complete 3
        videoAudit.setUuid(videoUUID);

        UnderReviewVideo underReviewVideo = new UnderReviewVideo();
        underReviewVideo.setBuildDashPath(accessMpdPath);
        underReviewVideo.setNumber(mergeChunkPoJo.getNumber());
        underReviewVideo.setOriginPath(localOriginPath);
        underReviewVideo.setFileMd5(mergeChunkPoJo.getFileMd5());
        underReviewVideo.setDuration(duration);
        underReviewVideo.setFileSize(mergeChunkPoJo.getFileSize());
        underReviewVideo.setFileType(videoType);
        underReviewVideo.setFileName(mergeChunkPoJo.getFileName());
        underReviewVideo.setUuid(videoUUID);
        underReviewVideo.setThumbnailPath(accessThumbnailPath);
        underReviewVideo.setUploadDate(simpleDateFormat.format(new Date()));
        underReviewVideo.setStoreHouseUUID(soreHouseUUID);
        underReviewVideo.setAuditVideoAccessPath(accessAuditVideoUrl);

        //db审核状态
        videoAuditMapper.insert(videoAudit);

        //redis缓存视频数据
        redisUtils.set(REDIS_KEY+videoUUID, JSON.toJSONString(underReviewVideo));

    }
}
