package com.api.MeAdote.api.controller;


import com.api.MeAdote.domain.model.Animal;
import com.api.MeAdote.domain.model.enums.Converter.*;
import com.api.MeAdote.domain.model.enums.Especie;
import com.api.MeAdote.domain.model.enums.FaixaEtaria;
import com.api.MeAdote.domain.model.enums.Porte;
import com.api.MeAdote.domain.model.enums.Sexo;
import com.api.MeAdote.domain.model.exception.EntidadeNaoEncontradaException;
import com.api.MeAdote.domain.repository.AnimalRepository;
import com.api.MeAdote.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalRepository repository;

    @Autowired
    AnimalService service;

    private static final String UPLOAD_DIR = "C:\\Users\\Fabio\\OneDrive\\Área de Trabalho\\FRONTEND\\Me-Adote\\public\\";



    @GetMapping
    public List<Animal> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorNome(@PathVariable Long id) {
        Optional<Animal> animal = repository.findById(id);

        if(animal != null) {
            return ResponseEntity.ok().body(animal);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> saveAnimal(@RequestParam("imagem") MultipartFile imagem,
                                             @ModelAttribute Animal animal) {

        try {
            if (imagem != null && !imagem.isEmpty()) {
                String nomeArquivo = StringUtils.cleanPath(imagem.getOriginalFilename());
                String caminhoCompleto = UPLOAD_DIR + nomeArquivo;

                // Salvar a imagem na pasta local
                Path path = Path.of(caminhoCompleto);
                Files.copy(imagem.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                animal.setCaminhoImagem(caminhoCompleto);
            }
            return ResponseEntity.ok().body(repository.save(animal));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o animal: " + e.getMessage());
        }

    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Especie.class, new EspecieConverterStringToEnum());
    }

    @InitBinder
    public void initBinder2(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(FaixaEtaria.class, new faixaEtariaConverterStringToEnum());
    }

    @InitBinder
    public void initBinder3(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Sexo.class, new SexoConverterStringToEnum());
    }

    @InitBinder
    public void initBinder4(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Porte.class, new PorteConverterStringToEnum());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        }catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
