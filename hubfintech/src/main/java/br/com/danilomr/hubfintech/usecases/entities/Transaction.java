package br.com.danilomr.hubfintech.usecases.entities;

import java.math.BigDecimal;

public class Transaction {

    private String date;
    private BigDecimal amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
