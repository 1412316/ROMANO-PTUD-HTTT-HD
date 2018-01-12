package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(Model model) {

        model.addAttribute("message", "This is a spring mvc tutorial");
        return "welcome";

    }
}
