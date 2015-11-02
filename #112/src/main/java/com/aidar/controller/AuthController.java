package com.aidar.controller;

import com.aidar.service.UserService;
import com.aidar.util.UserRegistrationFormValidator;
import com.aidar.util.form.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistrationFormValidator validator;

    @RequestMapping("/guest")
    public String getGuestPage() {
        return "guest";
    }

    @RequestMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userform", new UserRegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistrationPage(@ModelAttribute("userform") @Valid UserRegistrationForm userRegistrationForm,
                                          BindingResult bindingResult) {
        validator.validate(userRegistrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveNewUser(userRegistrationForm);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

}
