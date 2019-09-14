package br.com.danilomr.hubfintech.usecases.mappers;

import br.com.danilomr.hubfintech.fixtures.CardDataFixture;
import br.com.danilomr.hubfintech.gateways.data.CardData;
import br.com.danilomr.hubfintech.usecases.entities.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CardMapperUnitTest {

    @Test
    public void shouldConvertCardData() {

        final CardData cardData = CardDataFixture.defaultValues();
        final Card card = CardMapper.toEntity(cardData);

        assertNotNull(card);
        assertNotNull(card.getTransactions());
        assertEquals(card.getAvailableAmount(), cardData.getAvailableAmount());
        assertEquals(card.getCardNumber(), cardData.getCardNumber());
        assertEquals(card.getTransactions().size(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailCardDataNull() {
        CardMapper.toEntity(null);
    }
}
