package com.donguri.donation;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String LINE_PAY_URL = "https://sandbox-api-pay.line.me/v3/payments/request";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String amount = request.getParameter("amount");
            String donationId = request.getParameter("id");

            if (amount == null || amount.isEmpty() || donationId == null || donationId.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"status\":\"error\", \"message\":\"Donation ID and amount are required\"}");
                return;
            }

            // Retrieve donation details
            String donationIdStr = request.getParameter("id");
            if (donationIdStr == null || donationIdStr.isEmpty()) {
                donationIdStr = "defaultId"; // Replace with a valid default ID for testing
            }
            DAODonation.RDAO.daoDonation(request, response, donationIdStr, 1);

            String nonce = UUID.randomUUID().toString();
            JsonObject requestBody = createRequestBody(amount, donationId);
            String requestBodyString = requestBody.toString();
            String signature = createSignature(requestBodyString, nonce);

            HttpURLConnection connection = (HttpURLConnection) new URL(LINE_PAY_URL).openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-LINE-ChannelId", CHANNEL_ID);
            connection.setRequestProperty("X-LINE-Authorization-Nonce", nonce);
            connection.setRequestProperty("X-LINE-Authorization", signature);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(requestBodyString.getBytes(StandardCharsets.UTF_8));
            }

            int status = connection.getResponseCode();
            StringBuilder content = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            connection.disconnect();

            if (status == 200) {
                JsonObject responseBody = new Gson().fromJson(content.toString(), JsonObject.class);
                String paymentUrl = responseBody.getAsJsonObject("info").getAsJsonObject("paymentUrl").get("web").getAsString();

                response.setStatus(HttpServletResponse.SC_OK);
                JsonObject jsonResponse = new JsonObject();
                jsonResponse.addProperty("status", "success");
                jsonResponse.addProperty("paymentUrl", paymentUrl);
                response.getWriter().write(jsonResponse.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"status\":\"error\", \"message\":\"Failed to initiate payment\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private JsonObject createRequestBody(String amount, String donationId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("amount", amount);
        jsonObject.addProperty("donationId", donationId);
        // Add other necessary properties as per API requirements
        return jsonObject;
    }

    private String createSignature(String requestBodyString, String nonce) {
        String data = CHANNEL_SECRET + requestBodyString + nonce;
        return HmacSignature.encrypt(CHANNEL_SECRET, data);
    }

    static class HmacSignature {
        public static String encrypt(final String key, final String data) {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
                mac.init(secretKeySpec);
                byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
                return Base64.getEncoder().encodeToString(rawHmac);
            } catch (Exception e) {
                throw new RuntimeException("Failed to generate HMAC", e);
            }
        }
    }
}