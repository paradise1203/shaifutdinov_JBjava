package com.aidar.controller;

import com.aidar.service.MedClinicService;
import com.aidar.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    MedClinicService medClinicService;

    @Autowired
    ProviderService providerService;

    @RequestMapping("/home")
    public String showHomePage(ModelMap modelMap) {
        return "home";
    }

    @RequestMapping("/getClinicInfo")
    public String showClinicInfo(@RequestParam("name") String name, ModelMap modelMap) {
        modelMap.addAttribute("avgSal", medClinicService.getAverageSalary(name));
        modelMap.addAttribute("avgClinicCheck", medClinicService.getAverageClinicCheck(name));
        return "home";
    }

    @RequestMapping("/getOfficeInfo")
    public String showOfficeInfo(@RequestParam("city") String city, @RequestParam("street") String street,
                                 @RequestParam(name = "provider", required = false) String providerName, ModelMap modelMap) {
        modelMap.addAttribute("avgOfficeCheck", medClinicService.getAverageOfficeCheck(city, street));
        if (!providerName.isEmpty()) {
            modelMap.addAttribute("hasDelivered", providerService.hasDelivered(medClinicService.getOffice(city, street), providerName));
        }
        return "home";
    }

    @RequestMapping("/getParticularEmployee")
    public String showParticularSalary(@RequestParam("fio") String fio, ModelMap modelMap) {
        modelMap.addAttribute("partSal", medClinicService.getParticularSalary(fio, 0));
        modelMap.addAttribute("partWorExp", medClinicService.getWorkingExperience(fio, 0));
        return "home";
    }

    @RequestMapping("/getTop")
    public String showTop(ModelMap modelMap) {
        modelMap.addAttribute("topClCheck", medClinicService.getMostProfitableClinic());
        modelMap.addAttribute("topOffCheck", medClinicService.getMostProfitableOffice());
        return "home";
    }

}
