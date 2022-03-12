package scbc.liyongjie.servicesignapi.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import scbc.liyongjie.servicesignapi.dao.StoreHousePoMapper;
import scbc.liyongjie.servicesignapi.exception.StoreHouseBuildException;
import scbc.liyongjie.servicesignapi.po.StoreHousePo;
import scbc.liyongjie.servicesignapi.pojo.UserPoJo;
import scbc.liyongjie.servicesignapi.util.UUIDUtils;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/12
 *              视频流url：rootPath/+storeHouseUUID/+videoUUID/+dash/+videoUUID.mpd
 *              dash仓库 ：rootPath/+storeHouseUUID/+videoUUID/+dash/
 *              缩略图：rootPath/+storeHouseUUID/+videoUUID/+videoUUID+thumbnail.jpeg
 *              storeHouseUUID : rootPath/+storeHouseUUID/
 */

@Aspect
@Component
@PropertySource(value = {"classpath:config.properties"},encoding="utf-8")
public class InitStoreHouseAdvice {

    private static final Logger log = LoggerFactory.getLogger(InitStoreHouseAdvice.class);

    @Value("${upload.storePath}")
    private String rootPath;

    @Resource
    private StoreHousePoMapper storeHousePoMapper;

    @After("scbc.liyongjie.servicesignapi.aspect.SignAspect.signAspect()")
    public void initStoreHouse(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object var = args[0];
        UserPoJo userPoJo = (UserPoJo) var;

        String storeHouseUUID = UUIDUtils.getUUID();

        //朴实无华的创建一个专属文件夹作为user的视频仓库
        String storeHousePath = rootPath+storeHouseUUID;
        File storeHouseFolder= new File(storeHousePath);

        if (!storeHouseFolder.mkdir())
            throw new StoreHouseBuildException();
        log.info("初始化仓库创建成功");

        //db
        StoreHousePo storeHousePo = new StoreHousePo();
        storeHousePo.setStorehouse(storeHouseUUID);
        storeHousePo.setNumber(userPoJo.getNumber());
        storeHousePoMapper.insert(storeHousePo);

        log.info("仓库信息已存储至数据库-------{}",storeHousePo);
    }
}
