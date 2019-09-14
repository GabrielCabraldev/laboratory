package br.com.danilomr.hubfintech.entrypoints.mappers;

import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseTransactionDTO;
import br.com.danilomr.hubfintech.usecases.entities.Transaction;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseTransactionDTOMapper {

    /**
     *
     * Responsável por mapear a entidade de negócio para o objeto de resposta.
     * @param transaction
     * @return
     */
    public static ResponseTransactionDTO toDTO(final Transaction transaction) {

        Assert.notNull(transaction, "Transaction cannot be null");

        ResponseTransactionDTO response = new ResponseTransactionDTO();
        response.setAmount(getStringAmount(transaction.getAmount()));
        response.setDate(transaction.getDate());

        return response;
    }

    /**
     *
     * Responsável por mapear a entidade de negócio para o objeto de resposta.
     * @param transactionList
     * @return
     */
    public static List<ResponseTransactionDTO> toDTO(final List<Transaction> transactionList) {

        Assert.notNull(transactionList, "Transaction list cannot be null.");

        return transactionList.stream()
                .map(transaction -> toDTO(transaction))
                .collect(Collectors.toList());
    }

    private static String getStringAmount(final BigDecimal amount) {
        return amount.setScale(2).toString().replace(".", ",");
    }
}
