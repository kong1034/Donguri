package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAODonation daoDonation = new DAODonation();
        List<DTODonation> donations = daoDonation.getAllDonations();

        request.setAttribute("donations", donations);
        request.setAttribute("contentPage", "home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modalAmount = request.getParameter("modal_amount");
        String paymentUrl = createLinePayPayment(modalAmount);

        Map<String, String> result = new HashMap<>();
        if (paymentUrl != null) {
            result.put("status", "success");
            result.put("paymentUrl", paymentUrl);
        } else {
            result.put("status", "failure");
            result.put("message", "Failed to create payment URL");
        }

        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }

    private String createLinePayPayment(String amount) {
        // Payment creation logic here
        return null;
    }
}