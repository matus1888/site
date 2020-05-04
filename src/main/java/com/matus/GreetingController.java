package com.matus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class GreetingController {
    public Logger log = Application.log;

    @GetMapping("/greeting")
    public String greeting( Model model) {
        return "greeting";
    }
    @GetMapping("/")
    public String homepage(Model model){
        return "matusPage";
    }
    @GetMapping("/resume")
    public String matusPage(Model model) {
        return "matusPage";
    }
    @GetMapping("/analyzehh")
    public String analyzed(@RequestParam(name = "name", required = false, defaultValue = "1")String name, Model model) {

        log.info("value  'name' in class  'greetingController' = " +name);
        model.addAttribute("A", RecipientArticles.runner(name));
        return "analyzehh";
    }

}

