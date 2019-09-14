package br.com.danilomr.hubfintech.fixtures;

import br.com.danilomr.hubfintech.usecases.entities.Card;

import java.math.BigDecimal;

public class CardFixture {

    public static Card defaultValues() {
        Card card = new Card();
        card.setAvailableAmount(BigDecimal.valueOf(936.11));
        card.setCardNumber("1111222233334444");
        card.setTransactions(TransactionFixture.defaultListValues());

        return card;
    }
}
