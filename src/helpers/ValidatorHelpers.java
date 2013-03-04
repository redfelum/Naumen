package helpers;

import entity.Chapter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class ValidatorHelpers implements Validator {
    public boolean supports(Class<?> clazz) {
        return Chapter.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (target.getClass().getSimpleName().equals("Article")) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "body.empty", "Body name must not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortName", "shortName.empty", "Short  name must not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName.empty", "Full name  must not be empty.");
        }

        if (target.getClass().getSimpleName().equals("Chapter")) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortName", "shortName.empty", "Short  name must not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName.empty", "Full  name must not be empty.");
        }

    }
}
