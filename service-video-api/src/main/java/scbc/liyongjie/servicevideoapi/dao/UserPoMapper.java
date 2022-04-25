package scbc.liyongjie.servicevideoapi.dao;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicevideoapi.po.UserPo;

@Repository
public interface UserPoMapper {

    UserPo selectByPrimaryKey(String number);

}