package umc.spring.validation.annotation;

import umc.spring.validation.validator.MemberExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
@Target( { ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {

    String message() default "해당하는 유저가 존재하지 않습니다.";
    Class<?>[] groups() default {}; // 이게 무슨 의미??
    Class<? extends Payload>[] payload() default {}; // 이게 무슨 의미??
}
