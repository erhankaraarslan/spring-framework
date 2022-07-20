package com.karaarslan.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KursKoduConstraintValidator implements ConstraintValidator<KursKodu, String> {

	
	private String coursePrefix;
	
	@Override
	public void initialize(KursKodu theCourseCode) {
		coursePrefix=theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		
		if(theCode!=null)
		{
			
			result=theCode.startsWith(coursePrefix);
		}
		else
		{
			result = true;
		}

		return result;
	}

	

}
