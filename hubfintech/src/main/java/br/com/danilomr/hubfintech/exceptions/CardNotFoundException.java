package br.com.danilomr.hubfintech.exceptions;

public class CardNotFoundException extends BaseException {

    public CardNotFoundException() {
        super(ErrorEnum.CARD_NOT_FOUND);
    }
}
