package aidar.controller;

import aidar.SomeModel;
import aidar.SomeService;
import aidar.SomeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    private SomeService service = new SomeServiceImpl();

    @RequestMapping("/")
    public String greeting(ModelMap modelMap) {
        SomeModel model = new SomeModel(service.greeting());
        modelMap.addAttribute("greeting", model.getSpeech());
        return "index";
    }

}
