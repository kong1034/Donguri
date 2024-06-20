package com.donguri.sign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/LoginC")
public class LoginC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        request.setAttribute("contentPage", "/jsp/sign/login.jsp");
        request.getRequestDispatcher("l_index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DAOSign.RDAO.login(request, response);
		
		String loginChk = (String)request.getAttribute("result");
		System.out.println("check in loginc post");
		
		
		if (loginChk!= "logout") {
			String jwtToken = (String) request.getAttribute("jwtToken");
			Cookie jwtCookie = new Cookie("jwtToken", jwtToken);
			// login status time limit
			jwtCookie.setMaxAge(3600);
			response.addCookie(jwtCookie);
			request.getRequestDispatcher("HeaderC");
		}else{
			request.setAttribute("contentPage", "/jsp/sign/login.jsp");
			System.out.println("Can't Login");
			request.getRequestDispatcher("l_index.jsp").forward(request, response);
		}
		
	}

	
}