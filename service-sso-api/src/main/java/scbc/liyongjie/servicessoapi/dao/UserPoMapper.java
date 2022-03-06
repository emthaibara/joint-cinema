package scbc.liyongjie.servicessoapi.dao;

import org.springframework.stereotype.Repository;
import scbc.liyongjie.servicessoapi.po.UserPo;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */

@Repository
public interface UserPoMapper {

    UserPo selectByPrimaryKey(String uuid);

}