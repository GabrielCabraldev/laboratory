package br.com.danilomr.hubfintech.usecases;

import br.com.danilomr.hubfintech.exceptions.CardNotFoundException;
import br.com.danilomr.hubfintech.fixtures.CardDataFixture;
import br.com.danilomr.hubfintech.fixtures.TransactionDataFixure;
import br.com.danilomr.hubfintech.gateways.CardRepository;
import br.com.danilomr.hubfintech.gateways.TransactionRepository;
import br.com.danilomr.hubfintech.gateways.data.CardData;
import br.com.danilomr.hubfintech.gateways.data.TransactionData;
import br.com.danilomr.hubfintech.usecases.entities.ActionResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddActionUnitTest {

    @InjectMocks
    private AddAction addAction;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void shouldAddAction() throws CardNotFoundException {

        final String cardNumber = "1111222233334444";
        final String amount = "5,50";
        final CardData cardData = CardDataFixture.defaultValues();
        final TransactionData transactionData = TransactionDataFixure.defaultValues();

        when(cardRepository.findByCardNumber(cardNumber)).thenReturn(cardData);
        when(transactionRepository.save(any(TransactionData.class))).thenReturn(transactionData);

        final ActionResult actionResult = addAction.execute(cardNumber, amount);

        assertNotNull(actionResult);
        assertEquals(actionResult.getAction(), "withdraw");
        assertEquals(actionResult.getCode(), "00");
        assertTrue(!actionResult.getAuthorizationCode().isEmpty());

        verify(cardRepository, times(1)).findByCardNumber(cardNumber);
        verify(transactionRepository, times(1)).save(any(TransactionData.class));
    }

    @Test
    public void shouldReturn14ForCardNotFound() throws CardNotFoundException {

        final String cardNumber = "1111222233334444";
        final String amount = "5,50";

        when(cardRepository.findByCardNumber(cardNumber)).thenReturn(null);

        final ActionResult actionResult = addAction.execute(cardNumber, amount);

        assertNotNull(actionResult);
        assertEquals(actionResult.getAction(), "withdraw");
        assertEquals(actionResult.getCode(), "14");
        assertTrue(actionResult.getAuthorizationCode().isEmpty());

        verify(cardRepository, times(1)).findByCardNumber(cardNumber);
        verify(transactionRepository, never()).save(any(TransactionData.class));
    }

    @Test
    public void shouldReturn51ForInsufficientFunds() throws CardNotFoundException {

        final String cardNumber = "1111222233334444";
        final String amount = "5550,50";
        final CardData cardData = CardDataFixture.defaultValues();

        when(cardRepository.findByCardNumber(cardNumber)).thenReturn(cardData);

        final ActionResult actionResult = addAction.execute(cardNumber, amount);

        assertNotNull(actionResult);
        assertEquals(actionResult.getAction(), "withdraw");
        assertEquals(actionResult.getCode(), "51");
        assertTrue(actionResult.getAuthorizationCode().isEmpty());

        verify(cardRepository, times(1)).findByCardNumber(cardNumber);
        verify(transactionRepository, never()).save(any(TransactionData.class));
    }
}
