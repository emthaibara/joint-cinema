package scbc.liyongjie.servicessoapi.service;

import org.springframework.stereotype.Service;
import scbc.liyongjie.servicessoapi.dao.UserPoMapper;
import scbc.liyongjie.servicessoapi.enums.PrefixEnum;
import scbc.liyongjie.servicessoapi.exception.PasswordException;
import scbc.liyongjie.servicessoapi.po.UserPo;
import scbc.liyongjie.servicessoapi.pojo.UserPoJo;
import scbc.liyongjie.servicessoapi.util.JwtUtils;
import scbc.liyongjie.servicessoapi.util.PBKDF2Utils;
import scbc.liyongjie.servicessoapi.util.RedisUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
    private HttpServletResponse httpServletResponse;

    public void sso(UserPoJo userPoJo){

        UserPo userPo = userPoMapper.selectByPrimaryKey(userPoJo.getNumber());
        String number = userPo.getNumber();
        String pwdHash = userPo.getPwdshash();
        String pwdSalt = userPo.getPwdsalt();

        //比对校验密码是否上输入正确
        check(userPoJo.getPassword(),pwdHash,pwdSalt);

        //生成jwt+secret(采用java UUID生成)
        String secret = UUID.randomUUID().toString();
        String jwt = buildToken(number,secret);

        //redis双向绑定  token <--> number
        redisUtil.set(PrefixEnum.TOKEN.getPrefix()+jwt, secret);
        redisUtil.set(PrefixEnum.NUMBER.getPrefix()+number, jwt);

        //添加至header
        httpServletResponse.addHeader(PrefixEnum.TOKEN.getPrefix(), jwt);
    }

    private void check(String pwd,String pwdHash ,String pwdSalt){
        if (!PBKDF2Utils.check(pwd,pwdHash,pwdSalt))
            throw new PasswordException();
    }

    private String buildToken(String number,String secret){
        return JwtUtils.creatJwt(number,secret);
    }

}
