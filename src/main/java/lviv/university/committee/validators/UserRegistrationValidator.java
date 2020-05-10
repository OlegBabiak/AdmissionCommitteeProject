package lviv.university.committee.validators;

import lviv.university.committee.dtos.UserRegistrationRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserRegistrationRequest request = (UserRegistrationRequest) target;
        if (request.getFirstName().isEmpty()){
            errors.rejectValue("firstName", "firstNameIsEmpty", "First name can't be empty");
        }
        if (request.getLastName().isEmpty()){
            errors.rejectValue("lastName","lastNameIsEmpty", "Last name can't be empty");
        }
        if (request.getUserName().isEmpty()){
            errors.rejectValue("userName", "userNameIsEmpty","User name can't be empty");
        }
        if (request.getEmail().isEmpty()){
            errors.rejectValue("email", "emailIsEmpty","Email can't be empty");
        }
        if (request.getPassword().isEmpty()){
            errors.rejectValue("password", "passwordIsEmpty","Password can't be empty");
        }
    }
}