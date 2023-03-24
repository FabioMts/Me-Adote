package com.api.MeAdote.api.controller;


import com.api.MeAdote.domain.model.Animal;
import com.api.MeAdote.domain.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {


    @Autowired
    AnimalRepository repository;

    @PostMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        return repository.save(animal);
    }

}
