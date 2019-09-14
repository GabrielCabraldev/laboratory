package br.com.danilomr.hubfintech.entrypoints.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseActionDTO {

    @JsonProperty("action")
    private String action;

    @JsonProperty("code")
    private String code;

    @JsonProperty("authorization_code")
    private String authorizationCode;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }
}
