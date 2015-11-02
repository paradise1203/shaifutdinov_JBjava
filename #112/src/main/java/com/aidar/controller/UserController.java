package com.aidar.controller;

import com.aidar.model.User;
import com.aidar.service.PostService;
import com.aidar.service.UserService;
import com.aidar.util.Parser;
import com.aidar.util.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping("/main")
    public String getMainPage() {
        return "main";
    }

    @RequestMapping("/home")
    public
    @ResponseBody
    ModelAndView getHomePage(Model model) {
        User user = Security.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.getPosts(user));
        return new ModelAndView("home");
    }

    @RequestMapping("/users")
    public
    @ResponseBody
    ModelAndView getFriendsPage(Model model) {
        User user = Security.getCurrentUser();
        List<User> userList = userService.getUsers(user);
        model.addAttribute("hasUsers", !userList.isEmpty());
        model.addAttribute("users", userList);
        return new ModelAndView("users");
    }

    @RequestMapping("/users/showPage")
    public
    @ResponseBody
    ModelAndView getOtherUserPage(@RequestParam("id") String id, Model model) {
        User user = userService.getUser(Parser.parseId(id));
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.getPosts(user));
        model.addAttribute("principal", Security.getCurrentUser());
        return new ModelAndView("user");
    }

    @RequestMapping(value = "/posts/send", method = RequestMethod.POST)
    public
    @ResponseBody
    String sendPost(@RequestParam("post") String post, @RequestParam(value = "id", required = false) String id) {
        User user = Security.getCurrentUser();
        if (id != null) {
            postService.addPost(user, userService.getUser(Parser.parseId(id)), post);
        } else {
            postService.addPost(user, post);
        }
        return "<li>" + "You at " + new Date() + " : " + post + "</li>";
    }

}


