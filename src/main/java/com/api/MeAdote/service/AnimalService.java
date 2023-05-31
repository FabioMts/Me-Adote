package com.api.MeAdote.service;
import com.api.MeAdote.domain.model.Animal;
import com.api.MeAdote.domain.model.exception.EntidadeNaoEncontradaException;
import com.api.MeAdote.domain.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;


    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public void excluir (Long id) {
        try {
            animalRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de animal com o código %d", id));
        }
    }

}
