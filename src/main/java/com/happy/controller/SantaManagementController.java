package com.happy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class SantaManagementController {
    @RequestMapping("/santa")
    public String root(Locale locale, ModelMap model) {
        model.addAttribute("content", "santa_management_page");
        return "index";

    }
}