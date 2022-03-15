package scbc.liyongjie.serviceffmpegapi.util;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */

public class ConnectStringUtils {
    public static String buildPath(String... args){
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : args) {
            stringBuilder.append(arg);
        }
        return stringBuilder.toString();
    }
}
