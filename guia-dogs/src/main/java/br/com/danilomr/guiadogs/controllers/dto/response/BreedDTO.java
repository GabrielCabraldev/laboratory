package br.com.danilomr.guiadogs.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BreedDTO {

    private Long id;
    private String breedName;
    private String knownAs;
    private String description;
    private String mainImage;
    private String images;
}
