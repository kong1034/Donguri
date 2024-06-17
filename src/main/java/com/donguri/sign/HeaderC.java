package com.donguri.sign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HeaderC")
public class HeaderC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginChk = (String)request.getParameter("result");
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("jwtToken") && c.getValue().equals(request.getParameter("cookie_val"))) {
//				response.setStatus(response.SC_OK); // 200
//				
//				
//			}else {
//				response.setStatus(response.SC_BAD_REQUEST); // 404
//				
//				
//			}
//		}
//		
		
		// chk 말고 쿠키 유효 검사 (
		
		// If User Logged in -> show another header
		if (loginChk != "logout") {
			  request.setAttribute("MyPage", "jsp/sign/loginProfile.jsp");
			  request.setAttribute("LoginBtn", "jsp/sign/logoutBtn.jsp");     
			  request.setAttribute("loginChk", loginChk); // for the JS in header.jsp(hidden function)
			  System.out.println("성공");
		}
		else {
			request.setAttribute("loginChk", "logout"); 
		} 
		
		request.getRequestDispatcher("HC").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
