package com.autospare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth) {

        if (auth.getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
    return "redirect:/parts/dashboard";
}

        if (auth.getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals("ROLE_SELLER"))) {
    return "redirect:/parts/list";
}

        if (auth.getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals("ROLE_CUSTOMER"))) {
    return "redirect:/parts/list";
}

        return "redirect:/login";
    }
}