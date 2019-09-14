package br.com.danilomr.hubfintech.entrypoints.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultErrorDTO {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
