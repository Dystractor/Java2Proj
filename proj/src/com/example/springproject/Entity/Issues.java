package com.example.springproject.Entity;

import javax.persistence.*;

@Entity
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String issueId;

    private String issueName;
    private boolean state;//关闭为false，开启为true

    private String startDate;

    private String endDate;

    private String period;

    public Issues() {
    }
    public void setId(int id){this.id=id;}
    public int getId(){return id;}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }


    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}

