package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.repositories.AnimalRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/animals/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {

    @Autowired
    AnimalRepositories animalrepos;

    @GetMapping("/animals")
    public List<Animal> listAllAnimals(){
        return animalrepos.findAll();
    }

   @GetMapping("/{animalname}")
    public List<Animal> getAnimalsByAnimalName(@PathVariable String animalname){
        return animalrepos.findAllByAnimaltype(animalname);
    }
}
