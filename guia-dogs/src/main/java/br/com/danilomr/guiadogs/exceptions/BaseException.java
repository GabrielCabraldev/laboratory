package br.com.danilomr.guiadogs.exceptions;

import br.com.danilomr.guiadogs.enums.ExceptionEnum;

public class BaseException extends Exception {

    public BaseException(final ExceptionEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    private ExceptionEnum error;

    public ExceptionEnum getError() {
        return error;
    }

    public void setError(ExceptionEnum error) {
        this.error = error;
    }
}
