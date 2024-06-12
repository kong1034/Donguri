package com.donguri.donation;

import java.math.BigDecimal;

public class DTODonation {
    private String orderId;
    private BigDecimal amount;
    private String currency;

    public DTODonation(String orderId, BigDecimal amount, String currency) {
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
    }

    public String getOrderId() {
        return orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}