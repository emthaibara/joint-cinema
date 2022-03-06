package scbc.liyongjie.servicesignapi.service;

import com.password4j.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import scbc.liyongjie.servicesignapi.dao.NumberPoMapper;
import scbc.liyongjie.servicesignapi.dao.UserPoMapper;
import scbc.liyongjie.servicesignapi.exception.SignException;
import scbc.liyongjie.servicesignapi.po.NumberPo;
import scbc.liyongjie.servicesignapi.po.UserPo;
import scbc.liyongjie.servicesignapi.pojo.UserPoJo;
import scbc.liyongjie.servicesignapi.util.PBKDF2Utils;
import scbc.liyongjie.servicesignapi.util.UUIDUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */

@Service
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class SignService {

    private final Logger log = LoggerFactory.getLogger(SignService.class);

    @Value("${default.avatar.url}")
    private String defaultAvatar;

    @Resource
    private SimpleDateFormat simpleDateFormat;

    @Resource
    private NumberPoMapper numberPoMapper;

    @Resource
    private UserPoMapper userPoMapper;

    public Integer login(final UserPoJo userPoJo){
        isExist(userPoJo.getNumber());

        UserPo userPo = buildRecord(userPoJo);
        NumberPo numberPo = buildRecord(userPoJo.getNumber(),userPo.getUuid());
        numberPoMapper.insert(numberPo);

        return userPoMapper.insert(userPo);
    }

    private void isExist(final String number){
        if (Objects.isNull(numberPoMapper.selectByPrimaryKey(number)))
            throw new SignException();
    }

    private UserPo buildRecord(final UserPoJo userPoJo){
        UserPo userRecord = new UserPo();

        userRecord.setUuid(UUIDUtils.getUUID());
        userRecord.setAvatar(defaultAvatar);
        userRecord.setName(userPoJo.getName());
        userRecord.setDate(simpleDateFormat.format(new Date()));

        //对密码做hash，并存储salt，pepper固定在properties内
        Hash hash = PBKDF2Utils.PBKDF2(userPoJo.getPassword());
        userRecord.setPwdshash(hash.getResult());
        userRecord.setPwdsalt(hash.getSalt());

        log.info("有新的记录产生-----{}", userRecord);
        return userRecord;
    }

    private NumberPo buildRecord(final String number,final String uuid){
        NumberPo numberPo = new NumberPo();
        numberPo.setNumber(number);
        numberPo.setUuid(uuid);
        return numberPo;
    }

}
