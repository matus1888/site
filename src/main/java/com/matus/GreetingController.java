package com.matus;

import javafx.scene.paint.Stop;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class GreetingController {
    public Logger log = Application.log;
    public int pagi=1;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        return "matusPage";
    }

    @GetMapping("/")
    public String homepage(Model model) {
        return "greeting";
    }

    @GetMapping("/resume")
    public String matusPage(Model model) {
        return "greeting";
    }

    @GetMapping("/analyzehh")
    public String analyzed(Model model,
                           @RequestParam(name = "name", required = false, defaultValue = "0") String name,
                           @RequestParam(name = "next", required = false, defaultValue = "false") String next,
                           @RequestParam(name = "previous", required = false, defaultValue = "false") String previous) throws IOException {

        log.info("'name'= " + name + "; 'next'= " + next + "; 'previous'= " + previous);
        int paggig= Integer.valueOf(name);
        if(next.equals("true")){
            log.info("button 'previous' is active");
        }
        if(previous.equals("true")){
            log.info("button 'next' is active");
        }
        log.info("current page is "+paggig);
        List<Integer> pages = Paginator.getAListOfPages(paggig);
            model.addAttribute("A", Paginator.getProperties(paggig));
            model.addAttribute("p1", pages.get(0));
            model.addAttribute("p2", pages.get(1));
            model.addAttribute("p3", pages.get(2));
            model.addAttribute("p4", pages.get(3));
            model.addAttribute("p5", pages.get(4));
        return "analyzehh";
    }
}

