package br.com.danilomr.hubfintech.fixtures;

import br.com.danilomr.hubfintech.gateways.data.CardData;

import java.math.BigDecimal;

public class CardDataFixture {

    public static CardData defaultValues() {

        CardData cardData = new CardData();
        cardData.setAvailableAmount(BigDecimal.valueOf(1000));
        cardData.setId(1L);
        cardData.setCardNumber("1111222233334444");
        cardData.setTransactions(TransactionDataFixure.defaultListValues());

        return cardData;
    }
}
