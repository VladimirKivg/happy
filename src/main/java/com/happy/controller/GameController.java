package com.happy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller

public class GameController {
    @RequestMapping("/admin")
    public String root(Locale locale, ModelMap model) {
        model.addAttribute("content", "game_management");
        return "index";
    }
}

