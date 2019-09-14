package br.com.danilomr.hubfintech.usecases.mappers;

import br.com.danilomr.hubfintech.gateways.data.CardData;
import br.com.danilomr.hubfintech.gateways.data.TransactionData;
import br.com.danilomr.hubfintech.usecases.entities.Card;
import br.com.danilomr.hubfintech.usecases.entities.Transaction;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class CardMapper {

    /**
     *
     * Responsável por mapear o objeto de dados para a entidade de negócio.
     * @param cardData
     * @return
     */
    public static Card toEntity(final CardData cardData) {

        Assert.notNull(cardData, "Card data cannot be null.");
        Card card = new Card();
        card.setCardNumber(cardData.getCardNumber());
        card.setAvailableAmount(cardData.getAvailableAmount());
        card.setTransactions(toTransactionList(cardData.getTransactions()));

        return card;
    }

    private static List<Transaction> toTransactionList(final List<TransactionData> transactionDataList) {

        return transactionDataList == null || transactionDataList.isEmpty() ?
                new ArrayList<>() :
                TransactionMapper.toEntity(transactionDataList);
    }
}
