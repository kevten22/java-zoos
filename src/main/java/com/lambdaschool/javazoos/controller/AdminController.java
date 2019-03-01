package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.models.Telephone;
import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repositories.AnimalRepositories;
import com.lambdaschool.javazoos.repositories.TelephoneRepositories;
import com.lambdaschool.javazoos.repositories.ZooRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    ZooRepositories zoorepos;

    @Autowired
    TelephoneRepositories telerepos;

    @Autowired
    AnimalRepositories animalrepos;

//    PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
//
//    PUT /admin/phones/{id} - update the telephone referenced by the id number with the provided information
//
//    PUT /admin/animals/{id} - update the animal referenced by the id number with the provided information

    @PutMapping("/zoos/{id}")
    public Zoo changeZooById(@RequestBody Zoo newzoo, @PathVariable long zooid) throws URISyntaxException{

        Optional<Zoo> updateZoo = zoorepos.findById(zooid);
        if(updateZoo.isPresent())
        {
            if(newzoo.getTelephones() == null)
            {
                newzoo.setTelephones(updateZoo.get().getTelephones());
            }

            if(newzoo.getAnimals() == null){
                newzoo.setAnimals(updateZoo.get().getAnimals());
            }

            newzoo.setZooid(zooid);
            zoorepos.save(newzoo);
            return newzoo;
        }
        else{
            return null;
        }
    }
    @PutMapping("/phones/{id}")
    public Telephone changePhoneById(@RequestBody Telephone newphone, @PathVariable long phoneid) throws URISyntaxException{

        Optional<Telephone> updatePhone = telerepos.findById(phoneid);
        if(updatePhone.isPresent())
        {
            if(newphone.getZoo() == null) {
                newphone.setZoo(updatePhone.get().getZoo());
            }

            newphone.setPhoneid(phoneid);
            telerepos.save(newphone);
            return newphone;
        }
        else{
            return null;
        }
    }

    @PutMapping("/animals/{id}")
    public Animal changeAnimalById(@RequestBody Animal newanimal, @PathVariable long animalid) throws URISyntaxException{

        Optional<Animal> updateAnimal = animalrepos.findById(animalid);
        if(updateAnimal.isPresent())
        {
            if(newanimal.getZoos() == null)
            {
                newanimal.setZoos(updateAnimal.get().getZoos());
            }

            newanimal.setAnimalid(animalid);
            animalrepos.save(newanimal);
            return newanimal;
        }
        else{
            return null;
        }
    }

    @PostMapping("/zoos")
    public Zoo addNewZoo(@RequestBody Zoo newzoo) throws URISyntaxException{
        return zoorepos.save(newzoo);
    }

    @PostMapping("/phones")
    public Telephone addNewTelephone(@RequestBody Telephone newphone) throws URISyntaxException{
        return telerepos.save(newphone);
    }

    @PostMapping("/animals")
    public Animal addNewAnimal(@RequestBody Animal newanimal) throws URISyntaxException{
        return animalrepos.save(newanimal);
    }


}
