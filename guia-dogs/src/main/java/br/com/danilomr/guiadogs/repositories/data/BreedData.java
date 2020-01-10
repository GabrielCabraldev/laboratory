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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "breed_name")
    private String breedName;

    @Column(name = "known_as")
    private String knownAs;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "main_image")
    private String mainImage;

    @Column(name = "images", length = 4000)
    private String images;

}
