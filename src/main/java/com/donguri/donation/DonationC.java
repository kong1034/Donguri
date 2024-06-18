package com.donguri.donation;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.UUID;
import com.google.gson.Gson;

@WebServlet("/DonationC")
public class DonationC extends HttpServlet {
    private static final String CHANNEL_ID = "2005457884";
    private static final String CHANNEL_SECRET = "1c9de69727cb9106bbbaea16ad0fcc03";
    private static final String LINE_PAY_URL = "https://sandbox-api-pay.line.me/v3/payments/request";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String amount = request.getParameter("modal_amount");
        String orderId = UUID.randomUUID().toString();
        String nonce = UUID.randomUUID().toString();

        // Construct request body
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
        redirectUrls.setConfirmUrl("https://yourdomain.com/confirm");
        redirectUrls.setCancelUrl("https://yourdomain.com/cancel");
        paymentRequest.setRedirectUrls(redirectUrls);

        Gson gson = new Gson();
        String requestBody = gson.toJson(paymentRequest);

        String signature = HmacSignature.encrypt(CHANNEL_SECRET, CHANNEL_SECRET + LINE_PAY_URL + requestBody + nonce);

        // Mock response for testing
        String paymentUrl = "https://sandbox-web-pay.line.me/web/pay?transactionId=TEST_TRANSACTION_ID";

        response.setStatus(HttpServletResponse.SC_OK);
        out.print("{\"status\":\"success\", \"paymentUrl\":\"" + paymentUrl + "\"}");
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
}