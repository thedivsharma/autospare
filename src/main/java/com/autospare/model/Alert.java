package com.autospare.model;

public class Alert {

    private String alertId;
    private String message;
    private String type;

    public Alert() {
    }

    public Alert(String alertId, String message, String type) {
        this.alertId = alertId;
        this.message = message;
        this.type = type;
    }

    public String sendAlert() {
        return "Alert Sent: " + message;
    }

    public String getAlertId() {
        return alertId;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}