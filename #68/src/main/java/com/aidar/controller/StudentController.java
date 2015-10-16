package com.aidar.controller;

import com.aidar.model.Student;
import com.aidar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/home")
    public String showHomePage(ModelMap modelMap) {
        modelMap.addAttribute("student", new Student());
        return "home";
    }

    @RequestMapping("/totalScore")
    public String showTotalScore(@ModelAttribute Student student, ModelMap modelMap) {
        modelMap.addAttribute("score", studentService.getTotalScore(student));
        return "home";
    }

    @RequestMapping("/averageScore")
    public String showAverageScore(@ModelAttribute Student student, ModelMap modelMap) {
        modelMap.addAttribute("score", studentService.getAverageScore(student));
        return "home";
    }

    @RequestMapping("/particularScore")
    public String showParticularScore(@ModelAttribute Student student, @RequestParam("subject") Integer subject,
                                      ModelMap modelMap) {
        modelMap.addAttribute("score", studentService.getParticularScore(student, subject));
        return "home";
    }

}
