package com.ita.u1.skomorokhova.spring_boot.controller;

import com.ita.u1.skomorokhova.spring_boot.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private UserServiceImpl userService;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping(value = "/logout-action")
    public String logout(Model model) {
        model.addAttribute("logout", true);
        return "login";
    }

}
