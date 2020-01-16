package br.com.danilomr.guiadogs.services;

import br.com.danilomr.guiadogs.exceptions.BreedNotFoundException;
import br.com.danilomr.guiadogs.exceptions.InvalidKindException;
import br.com.danilomr.guiadogs.services.entity.Breed;

import javax.persistence.Column;
import java.util.List;

public interface BreedService {

    Breed findById(final Long id) throws BreedNotFoundException;

    List<Breed> findAll();

    List<Breed> findByKey(final String key);

    List<Breed> findByKind(final String kind);

    Breed save(final Breed breed) throws InvalidKindException;

    void delete(final Breed breed);
}
