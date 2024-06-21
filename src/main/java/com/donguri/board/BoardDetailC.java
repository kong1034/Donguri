package com.donguri.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardDetailC")
public class BoardDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	     DAOBoard.getOneBoardList(request);
	     
		request.setAttribute("contentPage", "/jsp/board/board_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fromMypage = request.getParameter("fromMypage");
		System.out.println("fromMypage parameter received: " + fromMypage);
		
	     DAOBoard.getOneBoardList(request);
	     
	     if (fromMypage != null) {
	            request.setAttribute("fromMypage", true);
	        }
	     
	     DAOBoard2.getVolunteerList(request);
	     
		request.setAttribute("contentPage", "/jsp/board/board_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	
	
	}

}
