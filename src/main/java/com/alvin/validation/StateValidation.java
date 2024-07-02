package com.alvin.validation;

import com.alvin.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * packageName com.alvin.validation
 *
 * @author 你的名字
 * @version JDK 8
 * @className StateValidation (此处以class为例)
 * @date 2024/7/2 星期二
 * @description TODO
 */
public class StateValidation implements ConstraintValidator<State, String> {
	/**
	 * @param value
	 * @param constraintValidatorContext
	 * @return
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (value == null) {
			return false;
		}
		return value.equals("已发布") || value.equals("草稿");
	}
}
