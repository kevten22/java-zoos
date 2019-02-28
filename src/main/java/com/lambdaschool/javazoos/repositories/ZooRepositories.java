package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZooRepositories extends JpaRepository<Zoo, Long> {
    List<Zoo> findAllByZooname(String zooname);
}
