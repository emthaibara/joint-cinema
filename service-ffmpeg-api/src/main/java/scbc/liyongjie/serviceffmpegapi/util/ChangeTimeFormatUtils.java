package scbc.liyongjie.serviceffmpegapi.util;

/**
 * @Author:SCBC_LiYongJie
 * @Author:SCBC_ZhenJiaXuan
 * @time:2022/4/16
 */


public class ChangeTimeFormatUtils {

    public static String changeDuration(String secondStr){
        String integerSecond = null;
        if (secondStr.contains(".")){
            integerSecond = secondStr.substring(0,secondStr.lastIndexOf("."));
        }else {
            integerSecond = secondStr;
        }
        return changeTimeFormat(Integer.parseInt(integerSecond));
    }

    private static String changeTimeFormat(int second) {
        int minute;
        int newMinute;
        int hour;
        int newSecond;
        newSecond=second%60;
        minute=second/60;
        hour=minute/60;
        newMinute=minute%60;
        return ConnectStringUtils.buildPath(String.valueOf(hour),"小时",String.valueOf(newMinute),"分钟",String.valueOf(newSecond),"秒");
    }

}
