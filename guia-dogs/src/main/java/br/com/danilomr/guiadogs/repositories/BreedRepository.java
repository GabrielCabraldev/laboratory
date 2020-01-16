package br.com.danilomr.guiadogs.repositories;

import br.com.danilomr.guiadogs.repositories.data.BreedData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BreedRepository extends CrudRepository<BreedData, Long> {

    List<BreedData> findAll();

    List<BreedData> findByBreedNameIgnoreCaseContaining(final String breedName);

    List<BreedData> findByKindIgnoreCase(final String kind);

    Optional<BreedData> findByBreedNameIgnoreCase(final String breedName);
}
