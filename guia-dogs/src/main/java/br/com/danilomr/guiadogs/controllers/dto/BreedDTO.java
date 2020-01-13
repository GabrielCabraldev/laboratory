package br.com.danilomr.guiadogs.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BreedDTO {

    private Long id;

    @NotBlank
    private String breedName;

    @NotBlank
    private String knownAs;

    @NotBlank
    private String description;

    @NotBlank
    private String mainImage;

    private String images;
}
