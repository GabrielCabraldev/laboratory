package br.com.danilomr.hubfintech.entrypoints.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseCardDTO {

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("availableAmount")
    private String availableAmount;

    @JsonProperty("transactions")
    private List<ResponseTransactionDTO> transactions;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(String availableAmount) {
        this.availableAmount = availableAmount;
    }

    public List<ResponseTransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ResponseTransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
