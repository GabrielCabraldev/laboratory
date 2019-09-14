package br.com.danilomr.hubfintech.gateways;

import br.com.danilomr.hubfintech.gateways.data.TransactionData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionData, Long> {
}
