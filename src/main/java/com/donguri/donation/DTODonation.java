package com.donguri.donation;

import com.google.gson.Gson;

public class DTODonation {
	private int no;
    private String title;
    private String date;
    private String thumnail;
    private int amount;
    private int sum;
    private String created_date;
    private String publisher;
    private String tag;
    private String content;
    
    public DTODonation() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
    
	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String create_date) {
		this.created_date = create_date;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toJson() {
		Gson g = new Gson();
		return g.toJson(this);
	}
}