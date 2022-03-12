package cn.scbc.servicevideouploadapi.utils;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/13
 */


public class BuildPathUtils {

    public static String buildPath(String... args){
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : args) {
            stringBuilder.append(arg);
        }
        return stringBuilder.toString();
    }

}
