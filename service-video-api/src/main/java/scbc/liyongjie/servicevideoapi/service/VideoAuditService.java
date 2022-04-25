package scbc.liyongjie.servicevideoapi.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import scbc.liyongjie.servicevideoapi.dao.VideoAuditMapper;
import scbc.liyongjie.servicevideoapi.pojo.UnderReviewVideo;
import scbc.liyongjie.servicevideoapi.pojo.UnderReviewVideoPoJo;
import scbc.liyongjie.servicevideoapi.util.RedisUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/4/18
 */

@Service
public class VideoAuditService {

    @Resource
    private VideoAuditMapper videoAuditMapper;

    @Resource
    private RedisUtils redisUtils;


    private static final String LOCAL = "/Users/lemt/Desktop/scbc.liyongjie/scbc.static";
    private static final String ACCESS_PREFIX = "/resources/video/";
    private static final String REDIS_KEY = "AUDIT_VIDEO";
    private static final String STATUS_PASS = "2";
    private static final String STATUS_FAIL = "-1";

    public List<UnderReviewVideoPoJo> getUnderReviewVideoPoJos(String number){
        List<UnderReviewVideoPoJo> underReviewVideoPoJos = new ArrayList<>();
        videoAuditMapper.selectAll()
                .stream()
                .filter(videoAudit -> videoAudit.getNumber().equals(number))
                .forEach(videoAudit -> {

            String uuid = videoAudit.getUuid();
            String json = redisUtils.get(REDIS_KEY+uuid);

            UnderReviewVideo underReviewVideo = JSON.parseObject(json,UnderReviewVideo.class);
            String duration = underReviewVideo.getDuration();
            String fileName = underReviewVideo.getFileName();
            String fileSize = underReviewVideo.getFileSize();
            String fileType = underReviewVideo.getFileType();
            String thumbnailPath = underReviewVideo.getThumbnailPath();
            String uploadDate = underReviewVideo.getUploadDate();

            UnderReviewVideoPoJo underReviewVideoPoJo = new UnderReviewVideoPoJo();
            underReviewVideoPoJo.setThumbnail(thumbnailPath);
            underReviewVideoPoJo.setName(fileName);
            underReviewVideoPoJo.setType(fileType);
            underReviewVideoPoJo.setDuration(duration);
            underReviewVideoPoJo.setSize(fileSize);
            underReviewVideoPoJo.setUploadDate(uploadDate);
            underReviewVideoPoJo.setStatus(videoAudit.getStatus());

            underReviewVideoPoJos.add(underReviewVideoPoJo);

            //视频审核通过并且视频流生成完毕
            if (videoAudit.getStatus().equals(STATUS_PASS)) {
                videoAuditMapper.deleteByPrimaryKey(uuid);
                redisUtils.delete(REDIS_KEY+uuid);
            }

            //视频审核失败
            if (videoAudit.getStatus().equals(STATUS_FAIL)){
                videoAuditMapper.deleteByPrimaryKey(uuid);
                redisUtils.delete(REDIS_KEY+uuid);
                //删除视频数据----md5.type----dashFolder
                String localAuditVideoPath = LOCAL+underReviewVideo.getAuditVideoAccessPath();
                String localDashFolderPath = LOCAL+ACCESS_PREFIX+underReviewVideo.getStoreHouseUUID()+"/"+uuid+"/";
                String localThumbnailPath = LOCAL+thumbnailPath;
                removeVideoData(localAuditVideoPath,localDashFolderPath,localThumbnailPath);
            }

        });
        return underReviewVideoPoJos;
    }

    private void removeVideoData(String localAuditVideoPath,String localDashFolderPath,String localThumbnailPath){
        try {
            Files.deleteIfExists(Paths.get(localAuditVideoPath));
            Files.deleteIfExists(Paths.get(localThumbnailPath));
            Files.deleteIfExists(Paths.get(localDashFolderPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
