package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.donguri.sign.DAOSign;
import io.jsonwebtoken.Claims;
import java.io.IOException;

@WebServlet("/DonationDetailC")
public class DonationDetailC extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try {
            Claims claims = DAOSign.extractAndValidateToken(request);
            DAOSign.getUserSession(request, response);
            request.setAttribute("userId", claims.get("userId"));
        } catch (Exception e) {
            request.setAttribute("userId", null);
        }

        String donationId = request.getParameter("id");
        if (donationId != null && !donationId.isEmpty()) {
            request.setAttribute("donationId", donationId);
            request.setAttribute("no", donationId);
            DAODonation.RDAO.getDonationByOne(request);
        } else {
            request.setAttribute("selected_info", new DTODonation()); // 빈 객체로 초기화
        }

        request.setAttribute("contentPage", "jsp/donation/donation_detail.jsp");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}