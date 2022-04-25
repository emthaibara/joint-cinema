package scbc.liyongjie.nettywebsocketserverhome.dao;


import org.springframework.stereotype.Repository;
import scbc.liyongjie.nettywebsocketserverhome.po.User;


@Repository
public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(String number);

}