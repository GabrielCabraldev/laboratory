package br.com.danilomr.hubfintech.entrypoints.mappers;

import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseCardDTO;
import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseTransactionDTO;
import br.com.danilomr.hubfintech.usecases.entities.Card;
import br.com.danilomr.hubfintech.usecases.entities.Transaction;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResponseCardDTOMapper {

    /**
     *
     * Responsável por mapear a entidade de negócio para o objeto de resposta.
     * @param card
     * @return
     */
    public static ResponseCardDTO toDTO(final Card card) {

        Assert.notNull(card, "Card cannot be null");

        ResponseCardDTO response = new ResponseCardDTO();
        response.setAvailableAmount(getStringAmount(card.getAvailableAmount()));
        response.setCardNumber(card.getCardNumber());
        response.setTransactions(toTransactionListDTO(card.getTransactions()));

        return response;
    }

    private static String getStringAmount(final BigDecimal amount) {
        return amount.setScale(2).toString().replace(".", ",");
    }

    private static List<ResponseTransactionDTO> toTransactionListDTO(List<Transaction> transactionList) {

        return transactionList == null | transactionList.isEmpty() ?
                new ArrayList<>() :
                ResponseTransactionDTOMapper.toDTO(transactionList);
    }
}
