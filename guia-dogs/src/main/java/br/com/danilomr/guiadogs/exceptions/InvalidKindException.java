package br.com.danilomr.guiadogs.exceptions;

import br.com.danilomr.guiadogs.enums.ExceptionEnum;

public class InvalidKindException extends BaseException {

    public InvalidKindException() {
        super(ExceptionEnum.INVALID_KIND);
    }
}
