package org.sha.ursip.validator;


import org.sha.ursip.model.Type;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TypeValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return Type.class.equals(paramClass);
    }
    public void validate(Object obj, Errors err) {
        ValidationUtils.rejectIfEmptyOrWhitespace(err, "typeName", "valid.types");
    }
}
