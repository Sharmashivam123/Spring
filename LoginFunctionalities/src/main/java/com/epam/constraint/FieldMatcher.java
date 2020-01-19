package com.epam.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatcher implements ConstraintValidator<FieldMatch, Object> {

	String first;
	String second;
	String message;

	@Override
	public void initialize(final FieldMatch context) {
		first = context.first();
		second = context.second();
		message = context.message();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		try {
			Object firstObj = BeanUtils.getProperty(value, first);
			Object secondObj = BeanUtils.getProperty(value, second);
			valid = (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
		} catch (Exception e) {

		}
		if (!valid)
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(first).addConstraintViolation()
					.disableDefaultConstraintViolation();
		return valid;
	}

}
