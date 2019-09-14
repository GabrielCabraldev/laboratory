package br.com.danilomr.hubfintech.usecases;

import br.com.danilomr.hubfintech.exceptions.CardNotFoundException;
import br.com.danilomr.hubfintech.gateways.CardRepository;
import br.com.danilomr.hubfintech.gateways.data.CardData;
import br.com.danilomr.hubfintech.usecases.entities.Card;
import br.com.danilomr.hubfintech.usecases.mappers.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCard {

    @Autowired
    private CardRepository cardRepository;

    /**
     *
     * Responsável por realizar a busca de um cartão pelo seu número
     * @param cardNumber
     * @return
     * @throws CardNotFoundException
     */
    public Card execute(final String cardNumber) throws CardNotFoundException {

        //Caso não encontre um cartão, uma mensagem de erro é exibida
        final CardData cardData = Optional.ofNullable(cardRepository.findByCardNumber(cardNumber))
                .orElseThrow(() -> new CardNotFoundException());

        return CardMapper.toEntity(cardData);
    }
}
