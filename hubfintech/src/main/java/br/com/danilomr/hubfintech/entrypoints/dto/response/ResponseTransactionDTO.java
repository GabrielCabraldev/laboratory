package br.com.danilomr.hubfintech.entrypoints.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseTransactionDTO {

    @JsonProperty("date")
    private String date;

    @JsonProperty("amount")
    private String amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
