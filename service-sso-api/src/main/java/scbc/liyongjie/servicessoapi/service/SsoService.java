package scbc.liyongjie.servicessoapi.service;

import org.springframework.stereotype.Service;
import scbc.liyongjie.servicessoapi.dao.NumberPoMapper;
import scbc.liyongjie.servicessoapi.dao.UserPoMapper;
import scbc.liyongjie.servicessoapi.po.UserPo;
import scbc.liyongjie.servicessoapi.pojo.UserPoJo;
import scbc.liyongjie.servicessoapi.util.RedisUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 *         任务主要有两个:
 *              1.密码校验
 *              2.生成jwt token 并存入redis + header
 */

@Service
public class SsoService {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserPoMapper userPoMapper;

    @Resource
    private NumberPoMapper numberPoMapper;

    @Resource
    private HttpServletResponse httpServletResponse;

    public void sso(UserPoJo userPoJo){
        String uuid = numberPoMapper.selectByPrimaryKey(userPoJo.getNumber()).getUuid();
        UserPo userPo = userPoMapper.selectByPrimaryKey(uuid);

        String pwdHash = userPo.getPwdshash();
        String pwdSalt = userPo.getPwdsalt();
    }

    private void check(){

    }
}
