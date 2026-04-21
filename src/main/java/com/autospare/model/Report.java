package com.autospare.model;

public class Report {

    private String reportId;
    private ReportType type;
    private String content;

    public Report() {
    }

    public Report(String reportId, ReportType type, String content) {
        this.reportId = reportId;
        this.type = type;
        this.content = content;
    }

    public String generateReport() {
        return type + " REPORT: " + content;
    }

    public String getReportId() {
        return reportId;
    }

    public ReportType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}