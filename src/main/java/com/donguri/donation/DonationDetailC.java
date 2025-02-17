package com.donguri.donation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.sign.DAOSign;

@WebServlet("/DonationDetailC")
public class DonationDetailC extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String donationNo = request.getParameter("no");
        System.out.println("Received Donation No: " + donationNo);

        if (donationNo == null || donationNo.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Donation No is missing");
            return;
        }

        DAOSign.getUserSession(request, response);
        DAODonation.RDAO.getDonationByOne(request, response);
        request.setAttribute("contentPage", "jsp/donation/donation_detail.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}