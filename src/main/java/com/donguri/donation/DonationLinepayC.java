package com.donguri.donation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@WebServlet("/DonationLinepayC")
public class DonationLinepayC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String API_URL = "https://sandbox-api-pay.line.me/v2/payments/request";

    private static String generateHmacSignature(String channelSecret, String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(channelSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] hmacSha256 = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hmacSha256);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMAC signature", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amountStr = request.getParameter("amount");
        BigDecimal amount = new BigDecimal(amountStr);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            JsonObject paymentRequest = new JsonObject();
            paymentRequest.addProperty("amount", amount);
            paymentRequest.addProperty("currency", "JPY");
            paymentRequest.addProperty("orderId", UUID.randomUUID().toString());
            paymentRequest.addProperty("productName", "Donation");
            
            JsonObject redirectUrls = new JsonObject();
            redirectUrls.addProperty("confirmUrl", "http://localhost:8080/Donguri/jsp/donation/donation.jsp");
            redirectUrls.addProperty("cancelUrl", "http://localhost:8080/Donguri/jsp/donation/donation.jsp");
            paymentRequest.add("redirectUrls", redirectUrls);

            String nonce = UUID.randomUUID().toString();
            String signature = generateHmacSignature(CHANNEL_SECRET, CHANNEL_SECRET + "/v2/payments/request" + paymentRequest.toString() + nonce);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("X-LINE-ChannelId", CHANNEL_ID)
                    .header("X-LINE-Authorization-Nonce", nonce)
                    .header("X-LINE-Authorization", signature)
                    .POST(HttpRequest.BodyPublishers.ofString(paymentRequest.toString()))
                    .build();

            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(httpResponse.body()).getAsJsonObject();

            if ("0000".equals(jsonResponse.get("returnCode").getAsString())) {
                String paymentUrl = jsonResponse.getAsJsonObject("info").getAsJsonObject("paymentUrl").get("web").getAsString();
                JsonObject successResponse = new JsonObject();
                successResponse.addProperty("status", "success");
                successResponse.addProperty("paymentUrl", paymentUrl);
                response.getWriter().print(successResponse.toString());
            } else {
                JsonObject errorResponse = new JsonObject();
                errorResponse.addProperty("status", "error");
                errorResponse.addProperty("message", jsonResponse.get("returnMessage").getAsString());
                response.getWriter().print(errorResponse.toString());
            }

        } catch (Exception e) {
            JsonObject errorResponse = new JsonObject();
            errorResponse.addProperty("status", "error");
            errorResponse.addProperty("message", "Exception: " + e.getMessage());
            response.getWriter().print(errorResponse.toString());
        }
    }
}