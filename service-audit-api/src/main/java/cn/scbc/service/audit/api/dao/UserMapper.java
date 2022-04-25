package cn.scbc.service.audit.api.dao;

import cn.scbc.service.audit.api.po.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String number);

    int insert(User record);

    User selectByPrimaryKey(String number);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}