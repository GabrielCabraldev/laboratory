package br.com.danilomr.hubfintech.entrypoints.mappers;

import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseTransactionDTO;
import br.com.danilomr.hubfintech.fixtures.TransactionFixture;
import br.com.danilomr.hubfintech.usecases.entities.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ResponseTransactionDTOMapperUnitTest {

    @Test
    public void shouldConvertTransaction() {

        final Transaction transaction = TransactionFixture.defaultValues();
        final ResponseTransactionDTO responseDTO = ResponseTransactionDTOMapper
                .toDTO(transaction);

        assertNotNull(responseDTO);
        assertEquals(responseDTO.getAmount(), transaction.getAmount().setScale(2).toString()
                .replace(".", ","));
        assertEquals(responseDTO.getDate(), transaction.getDate());
    }

    @Test
    public void shouldConvertTransactionList() {

        final List<Transaction> transactions = TransactionFixture.defaultListValues();
        final List<ResponseTransactionDTO> responseListDTO = ResponseTransactionDTOMapper
                .toDTO(transactions);

        assertNotNull(responseListDTO);
        assertEquals(responseListDTO.get(0).getAmount(), transactions.get(0).getAmount().setScale(2).toString()
                .replace(".", ","));
        assertEquals(responseListDTO.get(0).getDate(), transactions.get(0).getDate());
        assertEquals(responseListDTO.get(1).getAmount(), transactions.get(1).getAmount().setScale(2).toString()
                .replace(".", ","));
        assertEquals(responseListDTO.get(1).getDate(), transactions.get(1).getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailTransactionNull() {
        final Transaction transaction = null;
        ResponseTransactionDTOMapper.toDTO(transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailTransactionListNull() {
        final List<Transaction> transactions = null;
        ResponseTransactionDTOMapper.toDTO(transactions);
    }
}
