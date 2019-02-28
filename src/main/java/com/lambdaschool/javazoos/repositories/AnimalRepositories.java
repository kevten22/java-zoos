package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepositories extends JpaRepository<Animal, Long> {
}
