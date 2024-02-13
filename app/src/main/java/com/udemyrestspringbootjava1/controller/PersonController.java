package com.udemyrestspringbootjava1.controller;

import com.udemyrestspringbootjava1.model.Person;
import com.udemyrestspringbootjava1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") String personId){
        return service.findById(personId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person requestBody){
        return service.create(requestBody);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") String id){
        service.delete(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person requestBody){
        return service.update(requestBody);
    }
}
