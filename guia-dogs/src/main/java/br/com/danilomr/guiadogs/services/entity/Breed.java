package br.com.danilomr.guiadogs.services.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Breed {

    private Long id;
    private String breedName;
    private String knownAs;
    private String description;
    private String mainImage;
    private String images;
}
