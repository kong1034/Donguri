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
        String donationIdStr = request.getParameter("id");

        DAODonation.model(request, response);

        if (donationIdStr != null) {
            try {
                int donationId = Integer.parseInt(donationIdStr);

                DAODonationList daoDonation = new DAODonationList();
                DTODonationList donation = daoDonation.getDonationById(donationId);

                if (donation != null) {
                    request.setAttribute("donation", donation);
                    request.setAttribute("contentPage", "jsp/donation/donation_detail.jsp");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Donation not found");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid donation ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Donation ID is required");
        }
    }
}