package net.yeah.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymleafController {
    @RequestMapping(value = "/thymleaf/say",method = RequestMethod.GET)
    public String say() {
        return "index";
    }
}
