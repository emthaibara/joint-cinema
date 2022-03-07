package scbc.liyongjie.servicesignapi.dao;

import scbc.liyongjie.servicesignapi.po.UserPo;

public interface UserPoMapper {

    int insert(UserPo record);

    UserPo selectByPrimaryKey(String number);


}