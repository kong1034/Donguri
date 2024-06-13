package com.donguri.donation;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAODonation daoDonation = new DAODonation();
        List<DTODonation> donations = daoDonation.getAllDonations();

        request.setAttribute("donations", donations);
        request.setAttribute("contentPage", "jsp/donation/donation.jsp");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
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
        try {
            URL url = new URL("https://api-pay.line.me/v2/payments/request");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-LINE-ChannelId", "YOUR_CHANNEL_ID");
            conn.setRequestProperty("X-LINE-ChannelSecret", "YOUR_CHANNEL_SECRET");
            conn.setDoOutput(true);

            String jsonInputString = new ObjectMapper().writeValueAsString(Map.of(
                "amount", amount,
                "currency", "JPY",
                "orderId", "order12345",
                "packageName", "com.yourcompany.donation",
                "redirectUrls", Map.of(
                    "confirmUrl", "https://yourwebsite.com/confirm",
                    "cancelUrl", "https://yourwebsite.com/cancel"
                )
            ));

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            if (code == 200) {
                Map<String, Object> response = new ObjectMapper().readValue(conn.getInputStream(), Map.class);
                return (String) ((Map<String, Object>) response.get("info")).get("paymentUrl");
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}