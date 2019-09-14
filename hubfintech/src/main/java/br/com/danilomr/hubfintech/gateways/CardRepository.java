package br.com.danilomr.hubfintech.gateways;

import br.com.danilomr.hubfintech.gateways.data.CardData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<CardData, Long> {

    CardData findByCardNumber(final String cardNumber);

    List<CardData> findAll();
}
