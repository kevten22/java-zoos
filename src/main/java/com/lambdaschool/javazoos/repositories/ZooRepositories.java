package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepositories extends JpaRepository<Zoo, Long> {
}
