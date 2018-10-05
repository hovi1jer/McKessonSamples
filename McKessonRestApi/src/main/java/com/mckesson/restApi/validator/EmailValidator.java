package com.mckesson.restApi.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

	@Override
	public void initialize(EmailConstraint email) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext cxt) {
		//valid email regex
        String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
		return email != null && email.length() > 0 && pattern.matcher(email).matches();
	}
}

