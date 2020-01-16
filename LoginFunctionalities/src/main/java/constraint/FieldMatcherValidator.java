package constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatcherValidator implements ConstraintValidator<FieldMatch, Object> {

	private String first;
	private String second;
	private String message;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		first = constraintAnnotation.first();
		second = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		try {
			final Object firstObj = BeanUtils.getProperty(value, first);
			final Object secondObj = BeanUtils.getProperty(value, second);

			valid = (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));

		} catch (Exception ignore) {

		}
		if (!valid)
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(first).addConstraintViolation()
					.disableDefaultConstraintViolation();
		return valid;
	}

}
