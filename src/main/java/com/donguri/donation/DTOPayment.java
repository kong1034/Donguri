package com.donguri.donation;

import java.util.Date;

public class DTOPayment {
    private int p_no;
    private int d_no;
    private String u_id;
    private int p_price;
    private Date p_date;

    // Getters and setters for all fields
    public int getPNo() {
        return p_no;
    }

    public void setPNo(int p_no) {
        this.p_no = p_no;
    }

    public int getDNo() {
        return d_no;
    }

    public void setDNo(int d_no) {
        this.d_no = d_no;
    }

    public String getUId() {
        return u_id;
    }

    public void setUId(String u_id) {
        this.u_id = u_id;
    }

    public int getPPrice() {
        return p_price;
    }

    public void setPPrice(int p_price) {
        this.p_price = p_price;
    }

    public Date getPDate() {
        return p_date;
    }

    public void setPDate(Date p_date) {
        this.p_date = p_date;
    }
}