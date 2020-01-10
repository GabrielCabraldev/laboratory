package br.com.danilomr.guiadogs.repositories.mapper;

import br.com.danilomr.guiadogs.repositories.data.BreedData;
import br.com.danilomr.guiadogs.services.entity.Breed;

public class BreedDataMapper {

    public static BreedData toData(final Breed breed) {

        return BreedData.builder()
                .id(breed.getId())
                .breedName(breed.getBreedName())
                .description(breed.getDescription())
                .knownAs(breed.getKnownAs())
                .images(breed.getImages())
                .mainImage(breed.getMainImage())
                .build();
    }
}
