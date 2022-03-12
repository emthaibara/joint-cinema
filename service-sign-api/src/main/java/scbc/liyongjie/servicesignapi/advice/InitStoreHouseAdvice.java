package scbc.liyongjie.servicesignapi.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import scbc.liyongjie.servicesignapi.pojo.UserPoJo;
import scbc.liyongjie.servicesignapi.service.InitStoreHouseService;

import javax.annotation.Resource;

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
public class InitStoreHouseAdvice {

    @Resource
    private InitStoreHouseService initStoreHouseService;

    @After("scbc.liyongjie.servicesignapi.aspect.SignAspect.signAspect()")
    public void initStoreHouse(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object var = args[0];
        UserPoJo userPoJo = (UserPoJo) var;
        initStoreHouseService.initStoreHouse(userPoJo.getNumber());
    }
}
