package constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatcherValidator implements ConstraintValidator<FieldMatch, Object> {

	String first;
	String second;
	String message;

	@Override
	public void initialize(final FieldMatch annotation) {
		message = annotation.message();
		first = annotation.first();
		second = annotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean check = true;
		try {
			final Object firstObj = BeanUtils.getProperty(value, first);
			final Object secondObj = BeanUtils.getProperty(value, second);
			check = (firstObj == null && secondObj == null) || (firstObj != null && firstObj == secondObj);
		} catch (Exception e) {

		}

		if (!check)
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(first).addConstraintViolation()
					.disableDefaultConstraintViolation();

		return check;
	}

}
