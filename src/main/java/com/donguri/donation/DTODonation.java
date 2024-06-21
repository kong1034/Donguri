package com.donguri.donation;

import java.util.Date;

public class DTODonation {
    private int d_no;
    private String u_id;
    private String d_title;
    private String d_content;
    private Date d_date;
    private int p_no;
    private int p_price;
    private Date p_date;

    public DTODonation() {
        super();
    }

    public DTODonation(int d_no, String u_id, String d_title, String d_content, Date d_date, int p_no, int p_price, Date p_date) {
        super();
        this.d_no = d_no;
        this.u_id = u_id;
        this.d_title = d_title;
        this.d_content = d_content;
        this.d_date = d_date;
        this.p_no = p_no;
        this.p_price = p_price;
        this.p_date = p_date;
    }

    public int getD_no() {
        return d_no;
    }

    public void setD_no(int d_no) {
        this.d_no = d_no;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getD_title() {
        return d_title;
    }

    public void setD_title(String d_title) {
        this.d_title = d_title;
    }

    public String getD_content() {
        return d_content;
    }

    public void setD_content(String d_content) {
        this.d_content = d_content;
    }

    public Date getD_date() {
        return d_date;
    }

    public void setD_date(Date d_date) {
        this.d_date = d_date;
    }

    public int getP_no() {
        return p_no;
    }

    public void setP_no(int p_no) {
        this.p_no = p_no;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    @Override
    public String toString() {
        return "DTODonation [d_no=" + d_no + ", u_id=" + u_id + ", d_title=" + d_title + ", d_content=" + d_content
                + ", d_date=" + d_date + ", p_no=" + p_no + ", p_price=" + p_price + ", p_date=" + p_date + "]";
    }
}