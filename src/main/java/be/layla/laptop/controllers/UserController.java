package be.layla.laptop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        if (principal != null) return "redirect:/laptop";
        return "user/login";
    }


    @GetMapping("/logout")
    public String logout(Model model, Principal principal) {
        if (principal == null) return "redirect:/laptop";
        return "user/logout";
    }


    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) return "redirect:/laptop";
        return "user/register";
    }

}
