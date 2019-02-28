package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repositories.AnimalRepositories;
import com.lambdaschool.javazoos.repositories.ZooRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/zoos/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {
    @Autowired
    ZooRepositories zoorepos;

    @GetMapping("/zoos")
    public List<Zoo> listAllZoos(){
        return zoorepos.findAll();
    }

    @GetMapping("/{name}")
    public List<Zoo> getZoosByZooName(@PathVariable String zooname){
        return zoorepos.findAllByZooname(zooname);
    }
}
