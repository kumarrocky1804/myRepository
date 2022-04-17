package com.SpringMVC.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// contrain validator class
@Constraint(validatedBy = CourseCodeValidator.class)
// where can we use this annotation
@Target({ElementType.METHOD,ElementType.FIELD})
// till when this will be retained
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode 
{
	public String value() default "CC";
	public String message() default "Should start with CC";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
