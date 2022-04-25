package scbc.liyongjie.servicenicknameapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicenicknameapi.po.User;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String number);

    int insert(User record);

    User selectByPrimaryKey(String number);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}