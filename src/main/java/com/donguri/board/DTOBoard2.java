package com.donguri.board;

import java.util.Date;

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
	
	public DTOBoard2() {
		// TODO Auto-generated constructor stub
	}

	public DTOBoard2(int no, int v_no, int g_no, String id, String tag, String title, String content, Date date,
			String img) {
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

	@Override
	public String toString() {
		return "DTOBoard2 [no=" + no + ", v_no=" + v_no + ", g_no=" + g_no + ", id=" + id + ", tag=" + tag + ", title="
				+ title + ", content=" + content + ", date=" + date + ", img=" + img + "]";
	}
}
