package com.alvin.anno;

import com.alvin.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * packageName com.alvin.anno
 *
 * @author 你的名字
 * @version JDK 8
 * @className State (此处以class为例)
 * @date 2024/7/2 星期二
 * @description TODO
 */
@Documented
@Constraint(validatedBy = {StateValidation.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
	String message() default "state的值只能是已发布|草稿";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
