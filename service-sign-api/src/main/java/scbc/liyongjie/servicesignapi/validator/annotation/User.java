package scbc.liyongjie.servicesignapi.validator.annotation;

import scbc.liyongjie.servicesignapi.validator.UserPoJoValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {UserPoJoValidate.class} //校验类
)

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface User {

    String message() default "用户注册信息存在格式异常";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
