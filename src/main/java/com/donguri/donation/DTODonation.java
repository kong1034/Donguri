package com.donguri.donation;

import java.util.Date;

public class DTODonation {
    private int donationNo;
    private String userId;
    private String donationTitle;
    private String donationContent;
    private Date donationDate;

    public DTODonation(int donationNo, String userId, String donationTitle, String donationContent, Date donationDate) {
        this.donationNo = donationNo;
        this.userId = userId;
        this.donationTitle = donationTitle;
        this.donationContent = donationContent;
        this.donationDate = donationDate;
    }

    // Getters and setters
    public int getDonationNo() {
        return donationNo;
    }

    public void setDonationNo(int donationNo) {
        this.donationNo = donationNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDonationTitle() {
        return donationTitle;
    }

    public void setDonationTitle(String donationTitle) {
        this.donationTitle = donationTitle;
    }

    public String getDonationContent() {
        return donationContent;
    }

    public void setDonationContent(String donationContent) {
        this.donationContent = donationContent;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }
}