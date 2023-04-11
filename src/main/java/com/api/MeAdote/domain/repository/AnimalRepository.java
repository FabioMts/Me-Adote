package com.api.MeAdote.domain.repository;

import com.api.MeAdote.domain.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal findByName(String name);

}
