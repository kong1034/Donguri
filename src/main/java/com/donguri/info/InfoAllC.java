package com.donguri.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoAllC")
public class InfoAllC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(num < 5 && num >= 0){
			if(num == 0) {
				
			} else if(num == 1) {
				request.setAttribute("contents", "/jsp/info/info_child.jsp");
			} else if(num == 2) {
				request.setAttribute("contents", "/jsp/info/info_older.jsp");
			} else if(num == 3) {
				request.setAttribute("contents", "/jsp/info/info_animal.jsp");
			} else if(num == 4) {
				
			}
			request.setAttribute("contentPage", "/jsp/info/info_all.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.setStatus(response.SC_BAD_REQUEST);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
