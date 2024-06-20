package com.donguri.donation;

import java.util.Date;

public class DTODonationList {
    private int dNo;
    private String uId;
    private String dTitle;
    private String dContent;
    private Date dDate;

    // Getters and setters for all fields
    public int getDNo() {
        return dNo;
    }

    public void setDNo(int dNo) {
        this.dNo = dNo;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getDTitle() {
        return dTitle;
    }

    public void setDTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    public String getDContent() {
        return dContent;
    }

    public void setDContent(String dContent) {
        this.dContent = dContent;
    }

    public Date getDDate() {
        return dDate;
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }
}