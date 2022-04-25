package cn.scbc.service.audit.api.dao;

import cn.scbc.service.audit.api.po.Video;
import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Video record);

    Video selectByPrimaryKey(String uuid);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}