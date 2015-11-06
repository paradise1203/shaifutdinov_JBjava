package com.aidar.util;

import com.aidar.model.User;
import com.aidar.model.enums.Sex;
import com.aidar.model.enums.UserRole;
import com.aidar.util.form.UserRegistrationForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRegistrationFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm userRegistrationForm) {
        User user = new User();
        user.setLogin(userRegistrationForm.getLogin());
        user.setPassword(encoder.encode(userRegistrationForm.getPassword()));
        user.setUserRole(UserRole.ROLE_USER);
        user.setFirstName(userRegistrationForm.getFirstName());
        user.setLastName(userRegistrationForm.getLastName());
        user.setSex(Sex.getSex(userRegistrationForm.getSex()));
        user.setCity(userRegistrationForm.getCity());
        user.setMobilePhone(userRegistrationForm.getMobilePhone());
        user.setEmail(userRegistrationForm.getEmail());
        return user;
    }

}
