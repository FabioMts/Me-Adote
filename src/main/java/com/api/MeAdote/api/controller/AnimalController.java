package com.api.MeAdote.api.controller;


import com.api.MeAdote.domain.model.Animal;
import com.api.MeAdote.domain.repository.AnimalRepository;
import com.api.MeAdote.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalRepository repository;

    @Autowired
    AnimalService service;

    @GetMapping
    public List<Animal> listar() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Animal> buscarPorNome(@PathVariable String name) {
        Animal animal = repository.findByName(name);

        if(animal != null) {
            return ResponseEntity.ok().body(animal);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        return repository.save(animal);
    }

}
