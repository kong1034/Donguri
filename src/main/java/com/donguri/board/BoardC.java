package com.donguri.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardC")
public class BoardC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DAOBoard.DAOB.getAllBoardList(request);
		DAOBoard.DAOB.paging(1, request);
		
		request.setAttribute("contentPage", "/jsp/board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DAOBoard.DAOB.search(request);
		
		request.setAttribute("contentPage", "/jsp/board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

}
