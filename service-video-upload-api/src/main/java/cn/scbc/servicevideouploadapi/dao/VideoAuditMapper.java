package cn.scbc.servicevideouploadapi.dao;

import cn.scbc.servicevideouploadapi.po.VideoAudit;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoAuditMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(VideoAudit record);

    VideoAudit selectByPrimaryKey(String uuid);

    List<VideoAudit> selectAll();

    int updateByPrimaryKey(VideoAudit record);
}