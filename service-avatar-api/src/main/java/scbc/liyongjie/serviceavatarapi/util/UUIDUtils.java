package scbc.liyongjie.serviceavatarapi.util;

import com.fasterxml.uuid.Generators;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */

public class UUIDUtils {

    public static String buildUUID(){
        return build();
    }

    private static String build(){
        return Generators.timeBasedGenerator().generate().toString();
    }

}
