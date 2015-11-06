package com.aidar.service.impl;

import com.aidar.annotation.ExceptionProcessor;
import com.aidar.annotation.TimeLogger;
import com.aidar.model.User;
import com.aidar.repository.UserRepository;
import com.aidar.service.UserService;
import com.aidar.util.UserRegistrationFormToUserTransformer;
import com.aidar.util.form.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @ExceptionProcessor
    @Override
    public void saveNewUser(UserRegistrationForm userRegistrationForm) {
        userRepository.save(UserRegistrationFormToUserTransformer.transform(userRegistrationForm));
        throw new RuntimeException();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @TimeLogger
    @Override
    public List<User> getUsers(User user) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        allUsers.remove(user);
        return allUsers;
    }

}
