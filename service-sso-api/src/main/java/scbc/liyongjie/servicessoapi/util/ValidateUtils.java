package scbc.liyongjie.servicessoapi.util;

import scbc.liyongjie.servicessoapi.enums.RegularExpressionEnum;
import scbc.liyongjie.servicessoapi.exception.BaseException;
import scbc.liyongjie.servicessoapi.pojo.SsoPoJo;

import java.util.regex.Pattern;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/3
 *          数据校验工具类
 */

public class ValidateUtils {

    public static void check(SsoPoJo userPoJo){
        if (!Pattern.matches(RegularExpressionEnum.NUMBER_RE.getRegularExpression(), userPoJo.getNumber()))
            throw new BaseException(RegularExpressionEnum.NUMBER_RE.getEffect());
    }

}
