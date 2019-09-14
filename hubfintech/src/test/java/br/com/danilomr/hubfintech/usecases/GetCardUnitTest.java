package br.com.danilomr.hubfintech.usecases;

import br.com.danilomr.hubfintech.exceptions.CardNotFoundException;
import br.com.danilomr.hubfintech.fixtures.CardDataFixture;
import br.com.danilomr.hubfintech.gateways.CardRepository;
import br.com.danilomr.hubfintech.gateways.data.CardData;
import br.com.danilomr.hubfintech.usecases.entities.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GetCardUnitTest {

    @InjectMocks
    private GetCard getCard;

    @Mock
    private CardRepository cardRepository;

    @Test
    public void shouldGetCard() throws CardNotFoundException {
        final String cardNumber = "1111222233334444";
        final CardData cardData = CardDataFixture.defaultValues();
        when(cardRepository.findByCardNumber(cardNumber))
                .thenReturn(cardData);

        final Card card = getCard.execute(cardNumber);

        assertNotNull(card);
        assertEquals(card.getCardNumber(), cardNumber);
        assertEquals(card.getAvailableAmount(), cardData.getAvailableAmount());

        verify(cardRepository, times(1)).findByCardNumber(cardNumber);
    }

    @Test(expected = CardNotFoundException.class)
    public void shouldFailCardNotFound() throws CardNotFoundException {
        final String cardNumber = "1111222233334444";
        when(cardRepository.findByCardNumber(cardNumber))
                .thenReturn(null);

        getCard.execute(cardNumber);

        verify(cardRepository, times(1)).findByCardNumber(cardNumber);
    }
}
