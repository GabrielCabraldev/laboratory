package br.com.danilomr.hubfintech.fixtures;

import br.com.danilomr.hubfintech.usecases.entities.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionFixture {

    public static Transaction defaultValues() {
        Transaction transaction = new Transaction();
        transaction.setDate("2019-09-01 02:45:59");
        transaction.setAmount(BigDecimal.valueOf(50.99));

        return transaction;
    }

    public static List<Transaction> defaultListValues() {

        List<Transaction> list = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        transaction1.setDate("2019-09-01 02:45:59");
        transaction1.setAmount(BigDecimal.valueOf(50.99));

        Transaction transaction2 = new Transaction();
        transaction2.setDate("2019-09-02 02:45:59");
        transaction2.setAmount(BigDecimal.valueOf(12.90));

        list.add(transaction1);
        list.add(transaction2);

        return list;
    }
}
