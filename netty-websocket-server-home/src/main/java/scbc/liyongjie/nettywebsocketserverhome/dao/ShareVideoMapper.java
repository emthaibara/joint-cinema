package scbc.liyongjie.nettywebsocketserverhome.dao;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserverhome.po.ShareVideo;


@Repository
public interface ShareVideoMapper {

    int insert(ShareVideo record);

}