package scbc.liyongjie.servicenicknameapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import scbc.liyongjie.servicenicknameapi.dao.UserMapper;
import scbc.liyongjie.servicenicknameapi.exception.UnRegisterException;
import scbc.liyongjie.servicenicknameapi.po.User;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */

@Service
public class NickNameService {

    private static final Logger log = LoggerFactory.getLogger(NickNameService.class);

    @Resource
    private UserMapper userMapper;

    public void seyNickName(String newNickName,String number){
        User user = userMapper.selectByPrimaryKey(number);

        if (Objects.isNull(user))
            throw new UnRegisterException();

        user.setName(newNickName);
        userMapper.updateByPrimaryKey(user);
        log.info("用户-----{}-----更改昵称为----{}",number,newNickName);
    }

}
