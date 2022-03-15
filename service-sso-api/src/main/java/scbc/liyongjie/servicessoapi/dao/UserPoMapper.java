package scbc.liyongjie.servicessoapi.dao;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicessoapi.po.UserPo;
@Repository
public interface UserPoMapper {

    UserPo selectByPrimaryKey(String number);

}