package com.donguri_board;

import java.util.Date;

public class DTOBoard {
	private int no;
	private String id;
	private String title;
	private String content;
	private Date date;
	private String status;
	private String place;
	private String img;

	public DTOBoard() {
		// TODO Auto-generated constructor stub
	}

	public DTOBoard(int no, String id, String title, String content, Date date, String status, String place,
			String img) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.status = status;
		this.place = place;
		this.img = img;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "DTOBoard [no=" + no + ", id=" + id + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", status=" + status + ", place=" + place + ", img=" + img + "]";
	}

	

}
