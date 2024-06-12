package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private DAODonation daoDonation = new DAODonation();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String donationNoStr = request.getParameter("donation_no");
        String userId = request.getParameter("user_id");
        String donationTitle = request.getParameter("donation_title");
        String donationContent = request.getParameter("donation_content");
        String donationDateStr = request.getParameter("donation_date");

        int donationNo = Integer.parseInt(donationNoStr);
        Date donationDate = java.sql.Date.valueOf(donationDateStr);

        daoDonation.saveDonation(donationNo, userId, donationTitle, donationContent, donationDate);

        List<DTODonation> donations = daoDonation.getAllDonations();
        request.setAttribute("donations", donations);
        request.setAttribute("contentPage", "jsp/donation/donation.jsp");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DTODonation> donations = daoDonation.getAllDonations();
        request.setAttribute("donations", donations);
        request.setAttribute("contentPage", "jsp/donation/donation.jsp");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}