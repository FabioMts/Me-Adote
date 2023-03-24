package com.api.MeAdote.domain.repository;

import com.api.MeAdote.domain.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {


}
