package com.donguri.donation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DonationMovePageC")
public class DonationMovePageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAODonation.RDAO.getAllDonations(request, response);
		int p = Integer.parseInt(request.getParameter("p"));
		DAODonation.RDAO.paging(p, request);
		
		request.setAttribute("contentPage", "jsp/donation/donation_list.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
