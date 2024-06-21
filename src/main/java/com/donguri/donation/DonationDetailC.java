package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet("/DonationDetailC")
public class DonationDetailC extends HttpServlet {
    private static final Logger logger = Logger.getLogger(DonationDetailC.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("content_page", "jsp/donation/donation_detail.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}