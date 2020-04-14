package com.thomas.pma.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//only executed on fieldvariables
@Target({ElementType.FIELD})
//done during runtime
@Retention(RetentionPolicy.RUNTIME)
//Class which contains the validation rules
@Constraint(validatedBy=UniqueValidator.class)
public @interface UniqueValue {
	
	String message() default "Unique Constraint violated!";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};
	
}
