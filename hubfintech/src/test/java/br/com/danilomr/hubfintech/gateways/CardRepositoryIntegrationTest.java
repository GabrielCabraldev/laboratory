package br.com.danilomr.hubfintech.gateways;

import br.com.danilomr.hubfintech.Application;
import br.com.danilomr.hubfintech.gateways.data.CardData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CardRepositoryIntegrationTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void shouldReturnCard() {
        final String cardNumber = "1111222233334444";
        CardData cardData = cardRepository.findByCardNumber(cardNumber);
        assertNotNull(cardData);
        assertEquals(cardData.getId(), Long.valueOf(1));
        assertEquals(cardData.getCardNumber(), cardNumber);
        assertEquals(cardData.getAvailableAmount(), BigDecimal.valueOf(1000).setScale(2));
    }

    @Test
    public void shouldNotFindCard() {
        final String cardNumber = "12345";
        CardData cardData = cardRepository.findByCardNumber(cardNumber);
        assertNull(cardData);
    }

}
