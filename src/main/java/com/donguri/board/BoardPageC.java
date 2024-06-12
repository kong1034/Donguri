package com.donguri.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardPageC")
public class BoardPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOBoard.getAllBoardList(request);
		int p = Integer.parseInt(request.getParameter("p"));
		DAOBoard.paging(p, request);

		request.setAttribute("content", "/jsp/board/board.jsp");
		request.getRequestDispatcher("/jsp/board/board_main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
