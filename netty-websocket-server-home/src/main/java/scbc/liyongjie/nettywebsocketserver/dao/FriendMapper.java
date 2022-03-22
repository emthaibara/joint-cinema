package scbc.liyongjie.nettywebsocketserver.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserver.po.Friend;

@Repository
public interface FriendMapper {
    int deleteByPrimaryKey(@Param("me") String me, @Param("friend") String friend);

    int insert(Friend record);

    List<Friend> selectAll();

    List<Friend> selectByMe(String number);

    List<Friend> selectByPrimaryKey(@Param("me") String me, @Param("friend") String friend);

}