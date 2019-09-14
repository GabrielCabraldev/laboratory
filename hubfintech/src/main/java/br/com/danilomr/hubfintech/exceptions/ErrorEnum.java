package br.com.danilomr.hubfintech.exceptions;

public enum ErrorEnum {

    CARD_NOT_FOUND("Card not found.", 404),
    INVALID_ACTION("Invalid action.", 400);

    ErrorEnum(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
