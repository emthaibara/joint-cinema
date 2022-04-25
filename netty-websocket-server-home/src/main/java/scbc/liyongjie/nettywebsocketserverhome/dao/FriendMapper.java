package scbc.liyongjie.nettywebsocketserverhome.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserverhome.po.Friend;

import java.util.List;

@Repository
public interface FriendMapper {
    int deleteByPrimaryKey(@Param("me") String me, @Param("friend") String friend);

    int insert(Friend record);

    List<Friend> selectByMe(String number);

    List<Friend> selectByPrimaryKey(@Param("me") String me, @Param("friend") String friend);

}