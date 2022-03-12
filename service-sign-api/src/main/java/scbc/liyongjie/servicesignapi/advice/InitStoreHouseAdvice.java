package scbc.liyongjie.servicesignapi.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import scbc.liyongjie.servicesignapi.pojo.UserPoJo;
import scbc.liyongjie.servicesignapi.util.UUIDUtils;

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



    @After("scbc.liyongjie.servicesignapi.aspect.SignAspect.signAspect()")
    public void initStoreHouse(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object var = args[0];
        UserPoJo userPoJo = (UserPoJo) var;
        String number = userPoJo.getNumber();
        String storeHouseUUID = UUIDUtils.getUUID();
        //持久化仓库信息
        String storeHousePath = rootPath+storeHouseUUID;
        File storeHouseFolder= new File(storeHousePath);
        boolean result = storeHouseFolder.mkdir();
        log.info("初始化仓库创建完毕 --------{}",result);
        //db

    }

}
