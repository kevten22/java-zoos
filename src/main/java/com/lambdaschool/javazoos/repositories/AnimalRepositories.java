package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepositories extends JpaRepository<Animal, Long> {
//  @Query(value = "SELECT animaltype FROM animal WHERE animaltype = :name", nativeQuery = true)
//  List<Animal> findAnimalsByName(String name);

    List<Animal> findAllByAnimaltype(String name);
}
