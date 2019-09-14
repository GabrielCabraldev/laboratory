package br.com.danilomr.hubfintech.exceptions;

public class BaseException extends Exception {

    public BaseException(final ErrorEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    private ErrorEnum error;

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }
}
