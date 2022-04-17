package com.SpringMVC.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidator 
	implements ConstraintValidator<CourseCode, String> 
{
	private String coursePrefix;
	@Override
	// 1st argument is actual value of the string passes and second can be used
	// to throw additional error messages
	public boolean isValid(String str, ConstraintValidatorContext arg1) 
	{
		if(str==null)
		{
			return false;
		}
		boolean res = str.startsWith(coursePrefix);
		
		return res;
	}

	@Override
	public void initialize(CourseCode constraintAnnotation) 
	{
		// the value passed through annotation "CC"
		coursePrefix = constraintAnnotation.value();
	}
	
}
