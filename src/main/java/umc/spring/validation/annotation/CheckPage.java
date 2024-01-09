package umc.spring.validation.annotation;

import umc.spring.validation.validator.MemberExistValidator;
import umc.spring.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 번호는 1 이상 입력해주세요.";
    Class<?>[] groups() default {}; // 이게 무슨 의미??
    Class<? extends Payload>[] payload() default {}; // 이게 무슨 의미??
}
