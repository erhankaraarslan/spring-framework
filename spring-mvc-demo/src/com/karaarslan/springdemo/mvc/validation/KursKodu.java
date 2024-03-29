package com.karaarslan.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = KursKoduConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface KursKodu {

	
	public String value() default "KURS";
	
	public String message() default "Kurs kodu KURS ile başlamalıdır";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};
	
	
}
