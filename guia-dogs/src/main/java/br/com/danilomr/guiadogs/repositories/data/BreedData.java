package br.com.danilomr.guiadogs.repositories.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@DynamicUpdate
public class BreedData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "breed_name", nullable = false)
    private String breedName;

    @Column(name = "known_as", nullable = false)
    private String knownAs;

    @Column(name = "description", length = 4000, nullable = false)
    private String description;

    @Column(name = "main_image", nullable = false)
    private String mainImage;

    @Column(name = "images", length = 4000)
    private String images;

    @Column(name = "kind", nullable = false)
    private String kind;

}
