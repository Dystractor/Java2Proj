package com.example.springproject.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Releases {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String releaseId;

    private Date releaseTime;

    private String whatDay;

    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getWhatDay() {
        return whatDay;
    }

    public void setWhatDay(String whatDay) {
        this.whatDay = whatDay;
    }


}
