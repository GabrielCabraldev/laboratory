package br.com.danilomr.guiadogs.enums;

public enum ExceptionEnum {

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
