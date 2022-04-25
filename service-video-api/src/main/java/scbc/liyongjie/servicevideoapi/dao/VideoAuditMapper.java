package scbc.liyongjie.servicevideoapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicevideoapi.po.VideoAudit;
@Repository
public interface VideoAuditMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(VideoAudit record);

    VideoAudit selectByPrimaryKey(String uuid);

    List<VideoAudit> selectAll();

    int updateByPrimaryKey(VideoAudit record);
}