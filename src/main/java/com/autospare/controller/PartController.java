package com.autospare.controller;

import com.autospare.model.Part;
import com.autospare.service.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parts")
public class PartController {

    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    // Show form
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("part", new Part());
        return "add-part";
    }

    // Save part
    @PostMapping("/save")
    public String savePart(@ModelAttribute Part part) {
        partService.savePart(part);
        return "redirect:/parts/list";
    }

    // Show all parts
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
}
