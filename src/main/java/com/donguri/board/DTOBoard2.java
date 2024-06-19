package com.donguri.board;

import java.util.Date;

import com.google.gson.Gson;

public class DTOBoard2 {
	
	private int no;
	private int v_no;
	private int g_no;
	private String id;
	private String tag;
	private String title;
	private String content;
	private Date date;
	private String img;
	 private int c_no;
	 private String c_content;
	 private Date c_date;
	
	public DTOBoard2() {
		// TODO Auto-generated constructor stub
	}

	public DTOBoard2(int no, int v_no, int g_no, String id, String tag, String title, String content, Date date,
			String img, int c_no, String c_content, Date c_date) {
		super();
		this.no = no;
		this.v_no = v_no;
		this.g_no = g_no;
		this.id = id;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.date = date;
		this.img = img;
		this.c_no = c_no;
		this.c_content = c_content;
		this.c_date = c_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getV_no() {
		return v_no;
	}

	public void setV_no(int v_no) {
		this.v_no = v_no;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	@Override
	public String toString() {
		return "DTOBoard2 [no=" + no + ", v_no=" + v_no + ", g_no=" + g_no + ", id=" + id + ", tag=" + tag + ", title="
				+ title + ", content=" + content + ", date=" + date + ", img=" + img + ", c_no=" + c_no + ", c_content="
				+ c_content + ", c_date=" + c_date + "]";
	}
	
	public String toJSON() {
		Gson g = new Gson();
		return g.toJson(this);
	}
	
	
}