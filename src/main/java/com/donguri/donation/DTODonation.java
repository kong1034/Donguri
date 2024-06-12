package com.donguri.donation;

import java.util.Date;

public class DTODonation {
    private int d_no;
    private String user_id;
    private String donation_title;
    private String donation_content;
    private Date donation_date;
    private int payment_no;
    private double price;
    private Date payment_date;

    // Getters and Setters
    public int getD_no() {
        return d_no;
    }

    public void setD_no(int d_no) {
        this.d_no = d_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDonation_title() {
        return donation_title;
    }

    public void setDonation_title(String donation_title) {
        this.donation_title = donation_title;
    }

    public String getDonation_content() {
        return donation_content;
    }

    public void setDonation_content(String donation_content) {
        this.donation_content = donation_content;
    }

    public Date getDonation_date() {
        return donation_date;
    }

    public void setDonation_date(Date donation_date) {
        this.donation_date = donation_date;
    }

    public int getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(int payment_no) {
        this.payment_no = payment_no;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }
}