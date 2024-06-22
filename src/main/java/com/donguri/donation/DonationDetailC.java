package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DonationDetailC")
public class DonationDetailC extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String donationIdStr = request.getParameter("id");
        DAODonation.RDAO.daoDonation(request, response, donationIdStr, 1);
        
        // Set contentPage attribute to point to donation_detail.jsp
        request.setAttribute("contentPage", "jsp/donation/donation_detail.jsp");
        
        // Forward to index.jsp to include header, footer and donation_detail.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}