package com.example.springproject.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Commits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String committerId;

    private Date commitDate;


    public Commits(){}

    public void setId(int id){this.id=id;}
    public int getId(){return this.id;}
    public String getCommitterId() {
        return committerId;
    }

    public void setCommitterId(String committerId) {
        this.committerId = committerId;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }
}
