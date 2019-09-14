package br.com.danilomr.hubfintech.usecases.entities;

import java.math.BigDecimal;
import java.util.List;

public class Card {

    private String cardNumber;
    private BigDecimal availableAmount;
    private List<Transaction> transactions;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
