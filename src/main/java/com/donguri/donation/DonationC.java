package com.donguri.donation;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;
import java.util.stream.Collectors;
import com.google.gson.Gson;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String LINE_PAY_URL = "https://sandbox-api-pay.line.me/v3/payments/request";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String amountStr = request.getParameter("amount");

        if (amountStr == null || amountStr.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"status\":\"error\", \"message\":\"Amount is required.\"}");
            out.flush();
            return;
        }

        try {
            int amount = Integer.parseInt(amountStr);
            String orderId = UUID.randomUUID().toString();
            String nonce = UUID.randomUUID().toString();

            // Construct request body
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setAmount(amount);
            paymentRequest.setCurrency("JPY");
            paymentRequest.setOrderId(orderId);

            PaymentPackage paymentPackage = new PaymentPackage();
            paymentPackage.setId("packageId");
            paymentPackage.setAmount(amount);
            paymentPackage.setName("Donation");

            Product product = new Product();
            product.setId("productId");
            product.setName("Donation Product");
            product.setQuantity(1);
            product.setPrice(amount);
            paymentPackage.setProducts(new Product[]{product});

            paymentRequest.setPackages(new PaymentPackage[]{paymentPackage});

            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setConfirmUrl("http://localhost:8080/Donguri/DonationC?status=confirm");
            redirectUrls.setCancelUrl("http://localhost:8080/Donguri/DonationC?status=cancel");
            paymentRequest.setRedirectUrls(redirectUrls);

            Gson gson = new Gson();
            String requestBody = gson.toJson(paymentRequest);

            String signature = HmacSignature.encrypt(CHANNEL_SECRET, CHANNEL_SECRET + LINE_PAY_URL + requestBody + nonce);

            // Send request to LINE Pay
            URL url = new URL(LINE_PAY_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-LINE-ChannelId", CHANNEL_ID);
            connection.setRequestProperty("X-LINE-Authorization-Nonce", nonce);
            connection.setRequestProperty("X-LINE-Authorization", signature);
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            os.close();

            if (connection.getResponseCode() == 200) {
                // Read response
                InputStream is = connection.getInputStream();
                String responseStr = new BufferedReader(new InputStreamReader(is))
                        .lines().collect(Collectors.joining("\n"));
                is.close();

                // Parse response to get paymentUrl
                PaymentResponse paymentResponse = gson.fromJson(responseStr, PaymentResponse.class);
                String paymentUrl = paymentResponse.getInfo().getPaymentUrl().getWeb();

                response.setStatus(HttpServletResponse.SC_OK);
                out.print("{\"status\":\"success\", \"paymentUrl\":\"" + paymentUrl + "\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.print("{\"status\":\"error\", \"message\":\"Failed to create payment.\"}");
            }

            out.flush();
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"status\":\"error\", \"message\":\"Invalid amount.\"}");
            out.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        if ("confirm".equals(status)) {
            // Handle confirmation logic here
            request.setAttribute("message", "Payment confirmed successfully.");
            request.getRequestDispatcher("/confirmation_page.jsp").forward(request, response);
        } else if ("cancel".equals(status)) {
            // Handle cancellation logic here
            request.setAttribute("message", "Payment cancelled.");
            request.getRequestDispatcher("/cancellation_page.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid status");
        }
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

    static class RedirectUrls {
        private String confirmUrl;
        private String cancelUrl;

        // Getters and setters
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

    static class PaymentResponse {
        private PaymentInfo info;

        public PaymentInfo getInfo() {
            return info;
        }

        public void setInfo(PaymentInfo info) {
            this.info = info;
        }
    }

    static class PaymentInfo {
        private PaymentUrl paymentUrl;

        public PaymentUrl getPaymentUrl() {
            return paymentUrl;
        }

        public void setPaymentUrl(PaymentUrl paymentUrl) {
            this.paymentUrl = paymentUrl;
        }
    }

    static class PaymentUrl {
        private String web;

        public String getWeb() {
            return web;
        }

        public void setWeb(String web) {
            this.web = web;
        }
    }
}