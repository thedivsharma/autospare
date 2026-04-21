package com.autospare.service;

import com.autospare.model.Part;
import com.autospare.repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public Part savePart(Part part) {
        return partRepository.save(part);
    }

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

    public Part getPartById(Long id) {
        return partRepository.findById(id).orElse(null);
    }

    public long getTotalParts() {
        return partRepository.count();
    }

    public long getLowStockCount() {
        return partRepository.findAll()
                .stream()
                .filter(p -> p.getQuantity() < 10)
                .count();
    }

    public double getTotalValue() {
        return partRepository.findAll()
                .stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }
}