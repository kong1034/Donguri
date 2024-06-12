package com.donguri.donation;

import java.math.BigDecimal;
import java.util.Date;

public class DTOPayment {
    private int paymentNo;
    private String userId;
    private BigDecimal price;
    private Date paymentDate;

    public DTOPayment(int paymentNo, String userId, BigDecimal price, Date paymentDate) {
        this.paymentNo = paymentNo;
        this.userId = userId;
        this.price = price;
        this.paymentDate = paymentDate;
    }

    // Getters and setters
    public int getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(int paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}