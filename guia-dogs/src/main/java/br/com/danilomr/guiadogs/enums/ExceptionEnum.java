package br.com.danilomr.guiadogs.enums;

public enum ExceptionEnum {

    INTERNAL_SERVER_ERROR("Internal server error", 500),
    INVALID_BODY_REQUEST("Invalid request body", 400),
    NULL_OR_EMPTY_FIELDS("Null or empty mandatory fields", 400),
    BREED_NOT_FOUND("Breed not found", 404);

    ExceptionEnum(String message, Integer code) {
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
