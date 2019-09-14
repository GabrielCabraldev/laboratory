package br.com.danilomr.hubfintech.entrypoints.enums;

public enum ActionEnum {

    WITHDRAW("withdraw");

    ActionEnum(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
