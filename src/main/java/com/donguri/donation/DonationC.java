package com.donguri.donation;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String LINE_PAY_URL = "https://sandbox-api-pay.line.me/v3/payments/request";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        String donationId = request.getParameter("id");

        // Ensure both id and amount are provided
        if (amount == null || amount.isEmpty() || donationId == null || donationId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"Donation ID and amount are required\"}");
            return;
        }

        try {
            String nonce = UUID.randomUUID().toString();
            JsonObject requestBody = createRequestBody(amount);
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
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
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
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    private JsonObject createRequestBody(String amount) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("amount", Integer.parseInt(amount));
        requestBody.addProperty("currency", "JPY");
        requestBody.addProperty("orderId", UUID.randomUUID().toString());

        JsonObject packages = new JsonObject();
        packages.addProperty("id", "donation_package");
        packages.addProperty("amount", Integer.parseInt(amount));
        packages.addProperty("name", "Donation Package");

        JsonObject product = new JsonObject();
        product.addProperty("id", "donation");
        product.addProperty("name", "Donation");
        product.addProperty("quantity", 1);
        product.addProperty("price", Integer.parseInt(amount));

        packages.add("products", product);
        requestBody.add("packages", packages);

        JsonObject redirectUrls = new JsonObject();
        redirectUrls.addProperty("confirmUrl", "https://yourdomain.com/confirm");
        redirectUrls.addProperty("cancelUrl", "https://yourdomain.com/cancel");

        requestBody.add("redirectUrls", redirectUrls);

        return requestBody;
    }

    private String createSignature(String requestBody, String nonce) throws Exception {
        String message = CHANNEL_SECRET + LINE_PAY_URL + requestBody + nonce;
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(CHANNEL_SECRET.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}