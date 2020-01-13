package br.com.danilomr.guiadogs.services.mapper;

import br.com.danilomr.guiadogs.controllers.dto.BreedDTO;
import br.com.danilomr.guiadogs.repositories.data.BreedData;
import br.com.danilomr.guiadogs.services.entity.Breed;

import java.util.List;
import java.util.stream.Collectors;

public class BreedMapper {

    public static Breed toEntity(final BreedData breedData) {

        return Breed.builder()
                .id(breedData.getId())
                .breedName(breedData.getBreedName())
                .knownAs(breedData.getKnownAs())
                .description(breedData.getDescription())
                .images(breedData.getImages())
                .mainImage(breedData.getMainImage())
                .build();
    }

    public static List<Breed> toEntityList(final List<BreedData> breedDataList) {

        return breedDataList.stream()
                .map(breedData -> toEntity(breedData))
                .collect(Collectors.toList());
    }

    public static Breed toEntity(final BreedDTO breedDTO) {

        return Breed.builder()
                .id(breedDTO.getId())
                .breedName(breedDTO.getBreedName())
                .knownAs(breedDTO.getKnownAs())
                .description(breedDTO.getDescription())
                .images(breedDTO.getImages())
                .mainImage(breedDTO.getMainImage())
                .build();
    }
}
