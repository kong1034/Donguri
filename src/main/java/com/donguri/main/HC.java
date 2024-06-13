package com.donguri.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.sign.DAOSign;

@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginChk = (String)request.getParameter("result");
		
		// If User Logged in -> show another header
		if ("login".equals(loginChk)) {
			  request.setAttribute("MyPage", "jsp/sign/loginProfile.jsp");
			  request.setAttribute("LoginBtn", "jsp/sign/logoutBtn.jsp");     
			  request.setAttribute("loginChk", "login"); // for the JS in header.jsp(hidden function)
			  System.out.println("성공");
		}
		else {
			request.setAttribute("loginChk", ""); 
			} 
		
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	
	}
			

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}
}
