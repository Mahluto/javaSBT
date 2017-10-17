package ru.sbt.bit.ood.solid.homework;

import java.time.LocalDate;

public class ReportParameters {

    public String departmentId;
    public LocalDate dateFrom;
    public LocalDate dateTo;
    public String recipients;

    public ReportParameters(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        this.departmentId = departmentId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.recipients = recipients;
    }
}
