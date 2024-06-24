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

		DAOBoard2.DAOB2.getAllEpilogue(request);
		int p = Integer.parseInt(request.getParameter("p"));
		DAOBoard2.DAOB2.paging(p, request);

		request.setAttribute("contentPage", "/jsp/board/board_epilogue.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOBoard.DAOB.getAllBoardList(request);
		int p = Integer.parseInt(request.getParameter("p"));
		DAOBoard.DAOB.paging(p, request);

		request.setAttribute("contentPage", "/jsp/board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
