package it.hrme.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    public static final String HOME = "/";

    @GetMapping(HOME)
    public String homePage() {
        return "home";
    }
}
