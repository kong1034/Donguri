package com.donguri.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardEpilogueDetailC")
public class BoardEpilogueDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DAOBoard2.getOneEpilogue(request);
		DAOBoard2.getComment(request);
		request.setAttribute("contentPage", "/jsp/board/board_epilogue_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DAOBoard2.getOneEpilogue(request);
		DAOBoard2.insertComment(request);
		request.setAttribute("contentPage", "/jsp/board/board_epilogue_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);}
	

}
