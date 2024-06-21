package com.donguri.donation;

import java.util.Date;

import com.google.gson.Gson;

public class DTODonation {
<<<<<<< HEAD
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
=======
    private String title;
    private String date;
    private String thumnail;
    private int amount;
    private int sum;
    
    public DTODonation() {
		// TODO Auto-generated constructor stub
	}
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getThumnail() {
		return thumnail;
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String toJson() {
		Gson g = new Gson();
		return g.toJson(this);
	}
>>>>>>> 5198b3f525911a1f6e8e47f4ba93a9c56d764d4e
}