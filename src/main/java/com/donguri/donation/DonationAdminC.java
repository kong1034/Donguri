package com.donguri.donation;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donguri.sign.DAOSign;
import com.donguri.sign.UserDTO;

@WebServlet("/DonationAdminC")
public class DonationAdminC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		String u_no = user.getU_no();
		
		if (u_no.equals("1")) {
			request.setAttribute("contentPage", "jsp/donation/donation_make.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.setStatus(response.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
