package com.jpaapp.tp5.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController {
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("message", "Bienvenue sur le panneau d'administration !");
        return "admin";
    }
}

