package com.aidar.util;

import com.aidar.model.User;
import com.aidar.repository.UserRepository;
import com.aidar.util.form.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationFormValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationForm user = (UserRegistrationForm) o;
        if (!user.getPassword().equals(user.getRepassword())) {
            errors.rejectValue("repassword", "", "Invalid password!");
        }
        if (userRepository.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "", "Login is already in use");
        }
    }

}
