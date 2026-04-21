package com.autospare.model;

public class Report {

    private String reportId;
    private String content;

    public Report() {
    }

    public Report(String reportId, String content) {
        this.reportId = reportId;
        this.content = content;
    }

    public String generateReport() {
        return content;
    }

    public String getReportId() {
        return reportId;
    }
}