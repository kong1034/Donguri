package com.donguri.sign;

import java.sql.Date;

import com.google.gson.Gson;

public class UserDTO {
	
	private String u_id;
	private String u_name;
	private String u_pw;
	private String u_grade;
	private String u_no;
	private String u_type;
	private String u_telenumber;
	private String u_email;
	private Date u_birth;
	private String u_profileimg;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		return "UserDTO [u_id=" + u_id + ", u_name=" + u_name + ", u_pw=" + u_pw + ", u_grade=" + u_grade + ", u_no="
				+ u_no + ", u_type=" + u_type + ", u_telenumber=" + u_telenumber + ", u_email=" + u_email + ", u_birth="
				+ u_birth + ", u_profileimg=" + u_profileimg + "]";
	}




	public UserDTO(String u_id, String u_name, String u_pw, String u_grade, String u_no, String u_type,
			String u_telenumber, String u_email, Date u_birth, String u_profileimg) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_grade = u_grade;
		this.u_no = u_no;
		this.u_type = u_type;
		this.u_telenumber = u_telenumber;
		this.u_email = u_email;
		this.u_birth = u_birth;
		this.u_profileimg = u_profileimg;
	}




	public String getU_id() {
		return u_id;
	}




	public void setU_id(String u_id) {
		this.u_id = u_id;
	}




	public String getU_name() {
		return u_name;
	}




	public void setU_name(String u_name) {
		this.u_name = u_name;
	}




	public String getU_pw() {
		return u_pw;
	}




	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}




	public String getU_grade() {
		return u_grade;
	}




	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}




	public String getU_no() {
		return u_no;
	}




	public void setU_no(String u_no) {
		this.u_no = u_no;
	}




	public String getU_type() {
		return u_type;
	}




	public void setU_type(String u_type) {
		this.u_type = u_type;
	}




	public String getU_telenumber() {
		return u_telenumber;
	}




	public void setU_telenumber(String u_telenumber) {
		this.u_telenumber = u_telenumber;
	}




	public String getU_email() {
		return u_email;
	}




	public void setU_email(String u_email) {
		this.u_email = u_email;
	}




	public Date getU_birth() {
		return u_birth;
	}




	public void setU_birth(Date u_birth) {
		this.u_birth = u_birth;
	}




	public String getU_profileimg() {
		return u_profileimg;
	}




	public void setU_profileimg(String u_profileimg) {
		this.u_profileimg = u_profileimg;
	}




	public String toJson() {
		Gson g = new Gson();
		return g.toJson(this);
	}
	
	
	
	
	
	
}
