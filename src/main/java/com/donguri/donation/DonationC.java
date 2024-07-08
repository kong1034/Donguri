package com.donguri.donation;

import com.google.gson.Gson;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String LINE_PAY_URL = "https://sandbox-api-pay.line.me";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        String json = sb.toString();
        Gson gson = new Gson();
        DonationRequest donationRequest = gson.fromJson(json, DonationRequest.class);

        String amount = donationRequest.getAmount();
        String donationId = donationRequest.getId();

        if (amount == null || amount.isEmpty() || Integer.parseInt(amount) <= 0) {
            response.setStatus(HttpURLConnection.HTTP_BAD_REQUEST);
            out.print("{\"status\": \"failure\", \"message\": \"Invalid amount.\"}");
            out.flush();
            return;
        }

        String orderId = UUID.randomUUID().toString();
        String nonce = UUID.randomUUID().toString();

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(Integer.parseInt(amount));
        paymentRequest.setCurrency("JPY");
        paymentRequest.setOrderId(orderId);

        PaymentPackage paymentPackage = new PaymentPackage();
        paymentPackage.setId("packageId");
        paymentPackage.setAmount(Integer.parseInt(amount));
        paymentPackage.setName("Donation");

        Product product = new Product();
        product.setId("productId");
        product.setName("Donation Product");
        product.setQuantity(1);
        product.setPrice(Integer.parseInt(amount));
        paymentPackage.setProducts(new Product[]{product});

        paymentRequest.setPackages(new PaymentPackage[]{paymentPackage});

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setConfirmUrl("http://localhost:8080/Donguri/donation_success.jsp");
        redirectUrls.setCancelUrl("http://localhost:8080/Donguri/donation_cancel.jsp");
        paymentRequest.setRedirectUrls(redirectUrls);

        String requestBody = gson.toJson(paymentRequest);

        String signature = HmacSignature.encrypt(CHANNEL_SECRET, CHANNEL_SECRET + "/v3/payments/request" + requestBody + nonce);

        // Send HTTP request
        URL url = new URL(LINE_PAY_URL + "/v3/payments/request");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-LINE-ChannelId", CHANNEL_ID);
        connection.setRequestProperty("X-LINE-Authorization-Nonce", nonce);
        connection.setRequestProperty("X-LINE-Authorization", signature);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = connection.getResponseCode();
        StringBuilder responseString = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                responseString.append(responseLine.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(HttpURLConnection.HTTP_INTERNAL_ERROR);
            out.print("{\"status\": \"failure\", \"message\": \"Error reading response from payment API\"}");
            out.flush();
            return;
        }

        if (code == HttpURLConnection.HTTP_OK) {
            response.setStatus(HttpURLConnection.HTTP_OK);
            out.print(responseString.toString());
        } else {
            response.setStatus(code);
            out.print("{\"status\": \"failure\", \"message\": \"Failed to initiate payment. HTTP response code: " + code + "\"}");
        }
        out.flush();
    }

    static class HmacSignature {
        public static String encrypt(final String key, final String data) {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
                mac.init(secretKeySpec);
                byte[] rawHmac = mac.doFinal(data.getBytes());
                return Base64.getEncoder().encodeToString(rawHmac);
            } catch (Exception e) {
                throw new RuntimeException("Failed to generate HMAC", e);
            }
        }
    }

    static class PaymentRequest {
        private int amount;
        private String currency;
        private String orderId;
        private PaymentPackage[] packages;
        private RedirectUrls redirectUrls;

        // Getters and setters
        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public PaymentPackage[] getPackages() {
            return packages;
        }

        public void setPackages(PaymentPackage[] packages) {
            this.packages = packages;
        }

        public RedirectUrls getRedirectUrls() {
            return redirectUrls;
        }

        public void setRedirectUrls(RedirectUrls redirectUrls) {
            this.redirectUrls = redirectUrls;
        }
    }

    static class PaymentPackage {
        private String id;
        private int amount;
        private String name;
        private Product[] products;

        // Getters and setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Product[] getProducts() {
            return products;
        }

        public void setProducts(Product[] products) {
            this.products = products;
        }
    }

    static class Product {
        private String id;
        private String name;
        private int quantity;
        private int price;

        // Getters and setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    static class DonationRequest {
        private String amount;
        private String id;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    static class RedirectUrls {
        private String confirmUrl;
        private String cancelUrl;

        public String getConfirmUrl() {
            return confirmUrl;
        }

        public void setConfirmUrl(String confirmUrl) {
            this.confirmUrl = confirmUrl;
        }

        public String getCancelUrl() {
            return cancelUrl;
        }

        public void setCancelUrl(String cancelUrl) {
            this.cancelUrl = cancelUrl;
        }
    }
}