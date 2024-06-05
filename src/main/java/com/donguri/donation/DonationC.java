package com.donguri.donation;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String API_URL = "https://sandbox-api-pay.line.me/v2/payments/request";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            JSONObject paymentRequest = new JSONObject();
            paymentRequest.put("productName", "기부금");
            paymentRequest.put("amount", Integer.parseInt(amount));
            paymentRequest.put("currency", "JPY");
            paymentRequest.put("orderId", UUID.randomUUID().toString());
            paymentRequest.put("confirmUrl", "http://localhost:8080/Donguri/success.jsp");
            paymentRequest.put("cancelUrl", "http://localhost:8080/Donguri/failure.jsp");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("X-LINE-ChannelId", CHANNEL_ID)
                    .header("X-LINE-ChannelSecret", CHANNEL_SECRET)
                    .POST(HttpRequest.BodyPublishers.ofString(paymentRequest.toString()))
                    .build();

            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(httpResponse.body());

            if ("0000".equals(jsonResponse.getString("returnCode"))) {
                String paymentUrl = jsonResponse.getJSONObject("info").getJSONObject("paymentUrl").getString("web");
                JSONObject successResponse = new JSONObject();
                successResponse.put("status", "success");
                successResponse.put("paymentUrl", paymentUrl);
                out.print(successResponse.toString());
            } else {
                JSONObject errorResponse = new JSONObject();
                errorResponse.put("status", "error");
                errorResponse.put("message", jsonResponse.getString("returnMessage"));
                out.print(errorResponse.toString());
            }
        } catch (Exception e) {
            JSONObject errorResponse = new JSONObject();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            try (PrintWriter out = response.getWriter()) {
                out.print(errorResponse.toString());
            }
        }
    }
}