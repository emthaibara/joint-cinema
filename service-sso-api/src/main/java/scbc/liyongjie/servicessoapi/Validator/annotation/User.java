package scbc.liyongjie.servicessoapi.Validator.annotation;


import scbc.liyongjie.servicessoapi.Validator.UserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {UserValidator.class} //校验类
)

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface User {

    String message() default "用户登录信息存在格式异常";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
