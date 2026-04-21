package com.autospare.controller;

import com.autospare.repository.OrderRepository;
import com.autospare.service.PartService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminFeatureController {

    private final PartService partService;
    private final OrderRepository orderRepository;

    public AdminFeatureController(PartService partService,
                                  OrderRepository orderRepository) {
        this.partService = partService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/reports")
    public String reports(Model model) {

        model.addAttribute("totalParts", partService.getTotalParts());
        model.addAttribute("lowStock", partService.getLowStockCount());
        model.addAttribute("totalValue", partService.getTotalValue());

        return "reports";
    }

    @GetMapping("/alerts")
    public String alerts() {
        return "alerts";
    }

    @GetMapping("/orders")
    public String orders(Model model) {

        model.addAttribute("orders", orderRepository.findAll());

        return "orders";
    }

    @GetMapping("/inventory-view")
    public String inventory() {
        return "inventory-view";
    }
}