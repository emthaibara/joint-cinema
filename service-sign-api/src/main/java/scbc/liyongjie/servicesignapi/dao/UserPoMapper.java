package scbc.liyongjie.servicesignapi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicesignapi.po.UserPo;

@Repository
public interface UserPoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserPo record);

    UserPo selectByPrimaryKey(String uuid);

    List<UserPo> selectAll();

    int updateByPrimaryKey(UserPo record);
}