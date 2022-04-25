package scbc.liyongjie.servicesignapi.util;

import scbc.liyongjie.servicesignapi.enums.RegularExpressionEnum;
import scbc.liyongjie.servicesignapi.exception.BaseException;
import scbc.liyongjie.servicesignapi.pojo.UserPoJo;

import java.util.regex.Pattern;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/3
 */

public class ValidateUtils {

    public static void check(UserPoJo userPoJo){

        if (!Pattern.matches(RegularExpressionEnum.NICKNAME_RE.getRegularExpression(), userPoJo.getName()))
            throw new BaseException(RegularExpressionEnum.NICKNAME_RE.getEffect());

        if (!Pattern.matches(RegularExpressionEnum.PSSWORD_RE.getRegularExpression(), userPoJo.getPassword()))
            throw new BaseException(RegularExpressionEnum.PSSWORD_RE.getEffect());

        if (!Pattern.matches(RegularExpressionEnum.NUMBER_RE.getRegularExpression(), userPoJo.getNumber()))
            throw new BaseException(RegularExpressionEnum.NUMBER_RE.getEffect());

    }

}
