package com.springmvc.util;

import com.springmvc.pojo.StudentNew;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("studentValidator")
public class StudentValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return StudentNew.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "name","required.name","Field name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "age","required.age","Field age is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "id","required.id","Field id is required.");
    }
}
