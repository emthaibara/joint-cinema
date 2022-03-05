package scbc.liyongjie.servicesignapi.utils;

import java.util.UUID;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */
public class UUIDUtils {

    public static String getUUID(){
        return creatUUID();
    }

    private static String creatUUID(){
        String s = UUID.randomUUID().toString();
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
    }

}
