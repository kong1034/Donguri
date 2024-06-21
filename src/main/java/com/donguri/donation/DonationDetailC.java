package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet("/DonationDetailC")
public class DonationDetailC extends HttpServlet {
    private static final Logger logger = Logger.getLogger(DonationDetailC.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String donationIdStr = request.getParameter("id");

        // Log received parameters
        logger.info("Received parameter - id: " + donationIdStr);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // If donationIdStr is provided, process the donation
        if (donationIdStr != null) {
            try {
                DAODonation.daoDonation(request, response, donationIdStr, 0);

                if (request.getAttribute("donation") != null) {
                    out.print("{\"status\":\"success\",\"message\":\"Donation details found\"}");
                } else {
                    out.print("{\"status\":\"error\",\"message\":\"Donation not found\"}");
                }
            } catch (SQLException e) {
                throw new ServletException("Database access error", e);
            }
        } else {
            out.print("{\"status\":\"error\",\"message\":\"Donation ID is required\"}");
        }
        out.flush();
    }
}