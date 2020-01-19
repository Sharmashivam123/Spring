package com.epam.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatcher.class)
@Documented
public @interface FieldMatch {
	String message() default "Password and Confirm Password Doesn't matches";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String first();
	String second();
	
	@Target(ElementType.ANNOTATION_TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List{
		FieldMatch[] value();
	}
}
