package scbc.liyongjie.nettywebsocketserverhome.dao;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserverhome.po.Video;

@Repository
public interface VideoMapper {

    int insert(Video record);

}