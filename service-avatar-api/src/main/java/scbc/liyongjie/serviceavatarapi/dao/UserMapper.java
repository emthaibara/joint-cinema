package scbc.liyongjie.serviceavatarapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.serviceavatarapi.po.User;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String number);

    int insert(User record);

    User selectByPrimaryKey(String number);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}