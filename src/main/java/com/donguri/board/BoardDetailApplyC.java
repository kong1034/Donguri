package com.donguri.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardDetailApplyC")
public class BoardDetailApplyC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DAOBoard2.DAOB2.applyVolunteer(request);
		
		//response.sendRedirect("BoardDetailC");
		  if (request.getAttribute("errorMessage") != null) {
	            request.setAttribute("contentPage", "/jsp/board/board_detail.jsp");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } else {
	            request.setAttribute("contentPage", "/jsp/board/board_detail.jsp");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
