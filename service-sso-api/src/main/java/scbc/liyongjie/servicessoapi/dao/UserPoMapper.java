package scbc.liyongjie.servicessoapi.dao;

import scbc.liyongjie.servicessoapi.po.UserPo;

public interface UserPoMapper {

    UserPo selectByPrimaryKey(String number);

}