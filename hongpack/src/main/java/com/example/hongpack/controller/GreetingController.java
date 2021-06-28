package com.example.hongpack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/notice")
    public String niceM(Model model){
        model.addAttribute("username", "wwnscjf");
        return "notice";
    }

    @GetMapping("/bye")
    public String SeeYou(Model model){
        model.addAttribute("neekname","홍박");
        return "Goodbye";
    }
}
