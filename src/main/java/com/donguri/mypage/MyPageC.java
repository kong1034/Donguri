package com.donguri.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.board.DAOBoard;
import com.donguri.board.DAOBoard2;
import com.donguri.donation.DAODonation;
import com.donguri.sign.DAOSign;

@WebServlet("/MyPageC")
public class MyPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		DAOBoard.DAOB.getMyBoard(request);
		DAOBoard2.DAOB2.getMyVolApply(request);
		DAODonation.RDAO.getDonationById(request);
		DAOBoard.DAOB.getMyLikes(request);
		//Get Session
		DAOSign.getUserSession(request, response);
		request.setAttribute("contentPage", "/jsp/mypage/mypage.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
