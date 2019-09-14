package br.com.danilomr.hubfintech.usecases.mappers;

import br.com.danilomr.hubfintech.fixtures.TransactionDataFixure;
import br.com.danilomr.hubfintech.gateways.data.TransactionData;
import br.com.danilomr.hubfintech.usecases.entities.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TransactionMapperUnitTest {

    @Test
    public void shouldConvertTransactionData() {

        final TransactionData transactionData = TransactionDataFixure.defaultValues();
        final Transaction transaction = TransactionMapper.toEntity(transactionData);

        assertNotNull(transaction);
        assertEquals(transaction.getAmount(), transactionData.getAmount());
        assertEquals(transaction.getDate(), transactionData.getDate());
    }

    @Test
    public void shouldConvertTransactionDataList() {
        final List<TransactionData> dataList = TransactionDataFixure.defaultListValues();
        final List<Transaction> transactionList = TransactionMapper.toEntity(dataList);

        assertNotNull(transactionList);
        assertEquals(transactionList.size(), 2);
        assertEquals(transactionList.get(0).getAmount(), dataList.get(0).getAmount());
        assertEquals(transactionList.get(0).getDate(), dataList.get(0).getDate());
        assertEquals(transactionList.get(1).getAmount(), dataList.get(1).getAmount());
        assertEquals(transactionList.get(1).getDate(), dataList.get(1).getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailNullTransactionData() {
        TransactionData data = null;
        TransactionMapper.toEntity(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailNullTransactionDataList() {
        List<TransactionData> dataList = null;
        TransactionMapper.toEntity(dataList);
    }
}
