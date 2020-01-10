package br.com.danilomr.guiadogs.controllers;

import br.com.danilomr.guiadogs.controllers.dto.mapper.BreedDTOMapper;
import br.com.danilomr.guiadogs.controllers.dto.response.BreedDTO;
import br.com.danilomr.guiadogs.controllers.dto.response.BreedListDTO;
import br.com.danilomr.guiadogs.exceptions.BreedNotFoundException;
import br.com.danilomr.guiadogs.services.BreedService;
import br.com.danilomr.guiadogs.services.entity.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/breed")
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
}
