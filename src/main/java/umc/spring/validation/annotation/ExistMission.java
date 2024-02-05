package umc.spring.validation.annotation;

import umc.spring.validation.validator.MissionExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class) // 복붙하다보니 여기를 StoreExistValidator로 해버려서 에러가 발생했었음.
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
    String message() default "해당하는 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {}; // 이게 무슨 의미??
    Class<? extends Payload>[] payload() default {}; // 이게 무슨 의미??
}
