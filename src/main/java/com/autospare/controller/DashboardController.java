package com.autospare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping("/seller/home")
    public String sellerHome() {
        return "seller-home";
    }

    @GetMapping("/customer/home")
    public String customerHome() {
        return "customer-home";
    }
}