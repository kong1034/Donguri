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
        String donationId = request.getParameter("id");

        DAODonation daoDonation = new DAODonation();
        DTODonation donation = daoDonation.getDonationById(donationId);

        request.setAttribute("donation", donation);
        request.setAttribute("contentPage", "jsp/donation/donation_detail.jsp");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}