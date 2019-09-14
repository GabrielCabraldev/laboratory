package br.com.danilomr.hubfintech.fixtures;

import br.com.danilomr.hubfintech.gateways.data.TransactionData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionDataFixure {

    public static TransactionData defaultValues() {
        TransactionData transaction = new TransactionData();
        transaction.setId(1L);
        transaction.setDate("2019-09-01 02:45:59");
        transaction.setAmount(BigDecimal.valueOf(50.99));

        return transaction;
    }

    public static List<TransactionData> defaultListValues() {

        List<TransactionData> list = new ArrayList<>();
        TransactionData transaction1 = new TransactionData();
        transaction1.setId(1L);
        transaction1.setDate("2019-09-01 02:45:59");
        transaction1.setAmount(BigDecimal.valueOf(50.99));

        TransactionData transaction2 = new TransactionData();
        transaction2.setId(2L);
        transaction2.setDate("2019-09-02 02:45:59");
        transaction2.setAmount(BigDecimal.valueOf(12.90));

        list.add(transaction1);
        list.add(transaction2);

        return list;
    }
}
