package com.donguri.sign;

import java.sql.Date;

import com.google.gson.Gson;

public class XUserDTO {
	
	private String x_id; //screenName

	public XUserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getX_id() {
		return x_id;
	}



	public void setX_id(String x_id) {
		this.x_id = x_id;
	}
	

	@Override
	public String toString() {
		return "XUserDTO [x_id=" + x_id + "]";
	}



	public XUserDTO(String x_id) {
		super();
		this.x_id = x_id;
	}



	public String toJson() {
		Gson g = new Gson();
		return g.toJson(this);
	}


}
