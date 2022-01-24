package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @GetMapping({"/", "*"})
    public String addUser(@RequestParam(value = "id", defaultValue = "1", required = false) int id, Model model) {
        model.addAttribute("id", id);

        return "home"; // This refers to the page
    }
}
