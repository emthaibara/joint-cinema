package scbc.liyongjie.nettywebsocketserver.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserver.po.Video;
@Repository
public interface VideoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Video record);

    Video selectByPrimaryKey(String uuid);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}