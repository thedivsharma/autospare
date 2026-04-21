package com.autospare.model;

public class Admin {

    private Long adminId;
    private String name;

    public Admin() {
    }

    public Admin(Long adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    public Long getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }
}