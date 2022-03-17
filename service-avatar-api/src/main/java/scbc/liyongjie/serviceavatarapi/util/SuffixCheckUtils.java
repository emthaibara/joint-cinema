package scbc.liyongjie.serviceavatarapi.util;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/16
 */


public class SuffixCheckUtils {

    private static final List<String> SUFFIX = Arrays.asList("jpg","jpeg","png","svg","JPG");

    public static Boolean check(String suffix){
        return SUFFIX.contains(suffix);
    }

}
