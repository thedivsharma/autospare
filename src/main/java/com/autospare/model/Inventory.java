package com.autospare.model;

import java.util.List;

public class Inventory {

    private List<Part> spareParts;

    public Inventory() {
    }

    public Inventory(List<Part> spareParts) {
        this.spareParts = spareParts;
    }

    public List<Part> getSpareParts() {
        return spareParts;
    }

    public int getTotalItems() {
        return spareParts.size();
    }
}