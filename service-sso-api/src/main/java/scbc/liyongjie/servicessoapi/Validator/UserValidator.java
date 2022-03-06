package scbc.liyongjie.servicessoapi.Validator;

import org.springframework.validation.annotation.Validated;
import scbc.liyongjie.servicessoapi.Validator.annotation.User;
import scbc.liyongjie.servicessoapi.pojo.UserPoJo;
import scbc.liyongjie.servicessoapi.util.ValidateUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/3/5
 */

public class UserValidator implements ConstraintValidator<User, UserPoJo> {

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
