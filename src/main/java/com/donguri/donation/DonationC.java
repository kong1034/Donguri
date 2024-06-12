package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private DAODonation daoDonation = new DAODonation();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("order_id");
        String amountStr = request.getParameter("amount");
        String currency = request.getParameter("currency");

        BigDecimal amount = new BigDecimal(amountStr);
        boolean success = daoDonation.saveDonation(orderId, amount, currency);

        if (success) {
            request.setAttribute("message", "Payment successful.");
        } else {
            request.setAttribute("message", "Payment failed. Please try again.");
        }
        request.getRequestDispatcher("/index.jsp?page=jsp/donation/donation.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method is not supported");
    }
}