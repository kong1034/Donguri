package com.donguri.donation;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.Gson;

public class DTODonation {
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
}