package com.aidar.service;

import com.aidar.model.User;
import com.aidar.util.form.UserRegistrationForm;

import java.util.List;

public interface UserService {

    public void saveNewUser(UserRegistrationForm userRegistrationForm);

    public User getUser(Long id);

    public List<User> getUsers(User user);

}
