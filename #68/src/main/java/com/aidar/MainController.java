package com.aidar;

import com.aidar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @RequestMapping("/totalScore")
    public String showTotalScore(@RequestParam("fName") String fName, @RequestParam("sName") String sName,
                                 @RequestParam("lName") String lName, ModelMap modelMap) {
        modelMap.addAttribute("score", studentService.getTotalScore(fName, sName, lName));
        return "home";
    }

    @RequestMapping("/averageScore")
    public String showAverageScore(@RequestParam("fName") String fName, @RequestParam("sName") String sName,
                                   @RequestParam("lName") String lName, ModelMap modelMap) {
        modelMap.addAttribute("score", studentService.getAverageScore(fName, sName, lName));
        return "home";
    }

    @RequestMapping("/particularScore")
    public String showParticularScore(@RequestParam("fName") String fName, @RequestParam("sName") String sName,
                                      @RequestParam("lName") String lName, @RequestParam("subject") Integer subject,
                                      ModelMap modelMap) {
        modelMap.addAttribute("score", studentService.getParticularScore(fName, sName, lName, subject));
        return "home";
    }

}
