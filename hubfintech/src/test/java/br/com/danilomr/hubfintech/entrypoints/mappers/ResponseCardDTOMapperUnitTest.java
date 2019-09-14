package br.com.danilomr.hubfintech.entrypoints.mappers;

import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseCardDTO;
import br.com.danilomr.hubfintech.fixtures.CardFixture;
import br.com.danilomr.hubfintech.usecases.entities.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ResponseCardDTOMapperUnitTest {

    @Test
    public void shouldConvertCard() {

        final Card card = CardFixture.defaultValues();
        final ResponseCardDTO response = ResponseCardDTOMapper.toDTO(card);

        assertNotNull(response);
        assertNotNull(response.getTransactions());
        assertEquals(response.getAvailableAmount(), card.getAvailableAmount().toString()
                .replace(".", ","));
        assertEquals(response.getCardNumber(), card.getCardNumber());
        assertEquals(response.getTransactions().size(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailCardNull() {
        ResponseCardDTOMapper.toDTO(null);
    }
}
