package scbc.liyongjie.servicessoapi.Validator;

import scbc.liyongjie.servicessoapi.Validator.annotation.User;
import scbc.liyongjie.servicessoapi.pojo.SsoPoJo;
import scbc.liyongjie.servicessoapi.util.ValidateUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */

public class UserValidator implements ConstraintValidator<User, SsoPoJo> {

    @Override
    public void initialize(User constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SsoPoJo value, ConstraintValidatorContext context) {
        ValidateUtils.check(value);
        return Boolean.TRUE;
    }

}
