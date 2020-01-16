package br.com.danilomr.guiadogs.controllers.dto.mapper;

import br.com.danilomr.guiadogs.controllers.dto.BreedDTO;
import br.com.danilomr.guiadogs.controllers.dto.BreedListDTO;
import br.com.danilomr.guiadogs.services.entity.Breed;

import java.util.List;
import java.util.stream.Collectors;

public class BreedDTOMapper {

    public static BreedDTO toDTO(final Breed breed) {

        return BreedDTO.builder()
                .id(breed.getId())
                .breedName(breed.getBreedName())
                .description(breed.getDescription())
                .knownAs(breed.getKnownAs())
                .images(breed.getImages())
                .mainImage(breed.getMainImage())
                .kind(breed.getKind().name())
                .build();
    }

    public static BreedListDTO toDTOList(final List<Breed> breedList) {

        return BreedListDTO.builder()
                .breeds(breedList.stream()
                        .map(breed -> toDTO(breed))
                        .collect(Collectors.toList()))
                .build();
    }
}
