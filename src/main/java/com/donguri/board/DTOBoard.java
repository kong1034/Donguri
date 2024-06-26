package com.donguri.board;

import java.util.Date;

public class DTOBoard {
	private int no;
	private String id;
	private String title;
	private String content;
	private Date date;
	private Date startdate;
	private Date enddate;
	private Date meetdate;
	private String tag;
	private String status;
	private String place;
	private String img;

	public DTOBoard() {
		// TODO Auto-generated constructor stub
	}

	public DTOBoard(int no, String id, String title, String content, Date date, Date startdate, Date enddate,
			Date meetdate, String tag, String status, String place, String img) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.startdate = startdate;
		this.enddate = enddate;
		this.meetdate = meetdate;
		this.tag = tag;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
	
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	

	public Date getMeetdate() {
		return meetdate;
	}

	public void setMeetdate(Date meetdate) {
		this.meetdate = meetdate;
	}

	@Override
	public String toString() {
		return "DTOBoard [no=" + no + ", id=" + id + ", title=" + title + ", content=" + content + ", date=" + date
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", meetdate=" + meetdate + ", tag=" + tag
				+ ", status=" + status + ", place=" + place + ", img=" + img + "]";
	}

	
}
