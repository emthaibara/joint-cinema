package scbc.liyongjie.servicesignapi.validator;

import scbc.liyongjie.servicesignapi.pojo.UserPoJo;
import scbc.liyongjie.servicesignapi.utils.ValidateUtils;
import scbc.liyongjie.servicesignapi.validator.annotation.User;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/3
 */

public class UserPoJoValidate implements ConstraintValidator<User, UserPoJo> {

    @Override
    public void initialize(User constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserPoJo value, ConstraintValidatorContext context) {
        ValidateUtils.check(value);
        return Boolean.TRUE;
    }

}
