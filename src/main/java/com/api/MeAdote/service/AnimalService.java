package com.api.MeAdote.service;
import com.api.MeAdote.domain.model.Animal;
import com.api.MeAdote.domain.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;


    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

}
