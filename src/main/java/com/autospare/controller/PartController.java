package com.autospare.controller;

import com.autospare.model.Invoice;
import com.autospare.model.Order;
import com.autospare.model.Part;
import com.autospare.repository.OrderRepository;
import com.autospare.service.PartService;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;
    private final OrderRepository orderRepository;

    public PartController(PartService partService,
                          OrderRepository orderRepository) {
        this.partService = partService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("part", new Part());
        return "add-part";
    }

    @PostMapping("/save")
    public String savePart(@ModelAttribute Part part) {
        partService.savePart(part);
        return "redirect:/parts/list";
    }

    @GetMapping("/list")
    public String listParts(Model model) {
        model.addAttribute("parts", partService.getAllParts());
        return "list-parts";
    }

    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable Long id) {
        partService.deletePart(id);
        return "redirect:/parts/list";
    }

    @GetMapping("/edit/{id}")
    public String editPart(@PathVariable Long id, Model model) {
        Part part = partService.getPartById(id);
        model.addAttribute("part", part);
        return "add-part";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalParts", partService.getTotalParts());
        model.addAttribute("lowStock", partService.getLowStockCount());
        model.addAttribute("totalValue", partService.getTotalValue());
        return "dashboard";
    }

    @GetMapping("/buy/{id}")
    public String buyPart(@PathVariable Long id,
                          Authentication auth,
                          Model model) {

        Part part = partService.getPartById(id);

        if (part == null || part.getQuantity() <= 0) {
            return "redirect:/parts/list";
        }

        part.setQuantity(part.getQuantity() - 1);
        partService.savePart(part);

        Order order = new Order(
                auth.getName(),
                part.getName(),
                1,
                part.getPrice(),
                "PLACED",
                LocalDateTime.now()
        );

        orderRepository.save(order);

        Invoice invoice = new Invoice(
                System.currentTimeMillis(),
                auth.getName(),
                part.getName(),
                part.getPrice(),
                1,
                part.getPrice(),
                LocalDateTime.now()
        );

        model.addAttribute("invoice", invoice);

        return "invoice";
    }
}