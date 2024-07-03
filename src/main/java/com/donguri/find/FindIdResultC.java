package com.donguri.find;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FindIdResultC")
public class FindIdResultC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//Login Chk
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			response.sendRedirect("HC");
		}else {
			request.setAttribute("contentPage", "/jsp/find/find_id_result.jsp");
			request.getRequestDispatcher("l_index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
