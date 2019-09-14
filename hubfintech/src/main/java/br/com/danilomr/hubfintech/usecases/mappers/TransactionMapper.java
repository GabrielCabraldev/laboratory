package br.com.danilomr.hubfintech.usecases.mappers;

import br.com.danilomr.hubfintech.gateways.data.TransactionData;
import br.com.danilomr.hubfintech.usecases.entities.Transaction;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {

    /**
     *
     * Responsável por mapear o objeto de dados para a entidade de negócio.
     * @param transactionData
     * @return
     */
    public static Transaction toEntity(final TransactionData transactionData) {

        Assert.notNull(transactionData, "Transaction data cannot be null.");

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionData.getAmount());
        transaction.setDate(transactionData.getDate());

        return transaction;
    }

    /**
     *
     * Responsável por mapear o objeto de dados para a entidade de negócio.
     * @param transactionDataList
     * @return
     */
    public static List<Transaction> toEntity(final List<TransactionData> transactionDataList) {

        Assert.notNull(transactionDataList, "Transaction data list cannot be null.");

        List<Transaction> transactions = transactionDataList.stream()
                .map(transactionData -> toEntity(transactionData))
                .collect(Collectors.toList());

        return getLastTransactions(transactions);
    }

    private static List<Transaction> getLastTransactions(final List<Transaction> transactions) {

        if (transactions.size() > 10) {
            final int length = transactions.size();
            return transactions.subList(length - 10, length);
        }

        return transactions;
    }

}
