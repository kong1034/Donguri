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
//        String donationId = request.getParameter("id");
//        if (donationId == null) {
//            response.sendRedirect("/DonationC");
//            return;
//        }
//
//        DAODonation daoDonation = new DAODonation();
//        DTODonation donation = daoDonation.getDonationById(donationId);
//
//        if (donation == null) {
//            response.sendRedirect("/DonationC");
//            return;
//        }

        // Set any additional attributes if needed
        request.setAttribute("contentPage", "jsp/donation/donation_detail.jsp");

        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}