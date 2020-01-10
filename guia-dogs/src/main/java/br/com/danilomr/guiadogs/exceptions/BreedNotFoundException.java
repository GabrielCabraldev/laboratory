package br.com.danilomr.guiadogs.exceptions;

import br.com.danilomr.guiadogs.enums.ExceptionEnum;

public class BreedNotFoundException extends BaseException {

    public BreedNotFoundException() {
        super(ExceptionEnum.BREED_NOT_FOUND);
    }
}
