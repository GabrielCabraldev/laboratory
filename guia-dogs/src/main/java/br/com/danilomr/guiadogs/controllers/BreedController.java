package br.com.danilomr.guiadogs.controllers;

import br.com.danilomr.guiadogs.controllers.dto.BreedDTO;
import br.com.danilomr.guiadogs.controllers.dto.BreedListDTO;
import br.com.danilomr.guiadogs.controllers.dto.mapper.BreedDTOMapper;
import br.com.danilomr.guiadogs.exceptions.BreedNotFoundException;
import br.com.danilomr.guiadogs.exceptions.InvalidKindException;
import br.com.danilomr.guiadogs.services.BreedService;
import br.com.danilomr.guiadogs.services.entity.Breed;
import br.com.danilomr.guiadogs.services.mapper.BreedMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(path = "/breed")
@Validated
public class BreedController {

    @Autowired
    private BreedService breedService;

    @GetMapping(path = "/all")
    public ResponseEntity<BreedListDTO> getAllBreeds() {

        List<Breed> breedList = breedService.findAll();
        return ResponseEntity.ok(BreedDTOMapper.toDTOList(breedList));
    }

    @GetMapping(path = "/key/{key}")
    public ResponseEntity<BreedListDTO> searchBreedsByKey(@PathVariable("key") final String key) {

        List<Breed> breedList = breedService.findByKey(key);
        return ResponseEntity.ok(BreedDTOMapper.toDTOList(breedList));
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<BreedDTO> getBreedById(@PathVariable("id") final Long id) throws BreedNotFoundException {

        Breed breed = breedService.findById(id);
        return ResponseEntity.ok(BreedDTOMapper.toDTO(breed));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<BreedDTO> save(@Valid @RequestBody final BreedDTO breedDTO) throws InvalidKindException {
        Breed breed = BreedMapper.toEntity(breedDTO);
        breed = breedService.save(breed);

        return ResponseEntity.ok(BreedDTOMapper.toDTO(breed));
    }

    @GetMapping(path = "/pic/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getPic(@PathVariable("id") final Long id) throws IOException, BreedNotFoundException {

        Breed breed = breedService.findById(id);

        InputStream in = getClass()
                .getResourceAsStream(breed.getMainImage());

        return IOUtils.toByteArray(in);
    }

    @GetMapping(path = "/kind/{kind}")
    public ResponseEntity<BreedListDTO> searchBreedsByKind(@PathVariable("kind") final String kind) {

        List<Breed> breedList = breedService.findByKind(kind);
        return ResponseEntity.ok(BreedDTOMapper.toDTOList(breedList));
    }
}
