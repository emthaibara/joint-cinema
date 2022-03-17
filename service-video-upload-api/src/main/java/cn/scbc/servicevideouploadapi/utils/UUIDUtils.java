package cn.scbc.servicevideouploadapi.utils;

import com.fasterxml.uuid.Generators;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/4
 */
public class UUIDUtils {

    public static String getUUID(){
        return timeBasedGenerator();
    }

    private static String timeBasedGenerator(){
        /**
         * 使用基于时间+以太网地址联合 build的UUID确保时间空间上的唯一
         */
        return Generators.timeBasedGenerator().generate().toString();
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
