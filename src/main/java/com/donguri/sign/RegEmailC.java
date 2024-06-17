package com.donguri.sign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegEmailC")
public class RegEmailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// send e-mail confirm code & create the RandomNum Session 
		SignDAO.emailVerify(request,response);
		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().print("{\"message\": \"Email sent successfully!\"}");
//		response.getWriter().flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		SignDAO.chkConfirmNum(request);
		
		SignDAO.codeVerify(request,response);
		
		
		
		
	}

}
