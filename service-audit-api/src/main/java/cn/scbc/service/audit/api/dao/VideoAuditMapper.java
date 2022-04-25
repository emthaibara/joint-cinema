package cn.scbc.service.audit.api.dao;

import cn.scbc.service.audit.api.po.VideoAudit;
import java.util.List;

public interface VideoAuditMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(VideoAudit record);

    VideoAudit selectByPrimaryKey(String uuid);

    List<VideoAudit> selectAll();

    int updateByPrimaryKey(VideoAudit record);
}