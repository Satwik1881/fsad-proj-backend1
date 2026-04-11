package com.edupulse.backend.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class MonthlyPerformance {
    private String month;
    private Integer avg;

    public MonthlyPerformance() {}

    public MonthlyPerformance(String month, Integer avg) {
        this.month = month;
        this.avg = avg;
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public Integer getAvg() { return avg; }
    public void setAvg(Integer avg) { this.avg = avg; }
}
