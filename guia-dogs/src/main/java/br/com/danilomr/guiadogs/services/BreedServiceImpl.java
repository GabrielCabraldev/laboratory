package br.com.danilomr.guiadogs.services;

import br.com.danilomr.guiadogs.exceptions.BreedNotFoundException;
import br.com.danilomr.guiadogs.repositories.BreedRepository;
import br.com.danilomr.guiadogs.repositories.data.BreedData;
import br.com.danilomr.guiadogs.repositories.mapper.BreedDataMapper;
import br.com.danilomr.guiadogs.services.entity.Breed;
import br.com.danilomr.guiadogs.services.mapper.BreedMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService{

    @Autowired
    private BreedRepository breedRepository;

    @Override
    public Breed findById(Long id) throws BreedNotFoundException {

        Optional<BreedData> breedData = breedRepository.findById(id);

        if(!breedData.isPresent()) {
            throw new BreedNotFoundException();
        }

        return BreedMapper.toEntity(breedData.get());
    }

    @Override
    public List<Breed> findAll() {
        List<BreedData> breedDataList = breedRepository.findAll();

        if(breedDataList == null) {
            return new ArrayList<>();
        }

        return BreedMapper.toEntityList(breedDataList);
    }

    @Override
    public List<Breed> findByKey(String key) {

        if(StringUtils.isEmpty(key)) {
            return findAll();
        }

        List<BreedData> breedDataList = breedRepository.findByBreedNameIgnoreCaseContaining(key);

        if(breedDataList == null) {
            return new ArrayList<>();
        }

        return BreedMapper.toEntityList(breedDataList);
    }

    @Override
    public Breed save(Breed breed) {

        BreedData breedData = BreedDataMapper.toData(breed);
        return BreedMapper.toEntity(breedRepository.save(breedData));
    }

    @Override
    public void delete(Breed breed) {

        BreedData breedData = BreedDataMapper.toData(breed);
        breedRepository.delete(breedData);
    }
}
