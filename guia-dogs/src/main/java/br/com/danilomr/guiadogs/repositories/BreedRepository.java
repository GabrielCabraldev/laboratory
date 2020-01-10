package br.com.danilomr.guiadogs.repositories;

import br.com.danilomr.guiadogs.repositories.data.BreedData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends CrudRepository<BreedData, Long> {

    List<BreedData> findAll();

    List<BreedData> findByBreedNameIgnoreCaseContaining(final String breedName);
}
