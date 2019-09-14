package br.com.danilomr.hubfintech.entrypoints.enums;

public enum CodeEnum {

    APPROVED("00"),
    INSUFFICIENT_FUNDS("51"),
    INVALID_ACCOUNT("14"),
    ERROR("96");

    CodeEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
