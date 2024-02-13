package com.udemyrestspringbootjava1.service;

import com.udemyrestspringbootjava1.model.Person;
import com.udemyrestspringbootjava1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(String id){
        return repository.findById(Long.valueOf(id)).orElseThrow(IllegalArgumentException::new);
    }

    public Person create(Person p){
        return repository.save(p);
    }

    public void delete(String id){
        Person person = repository.findById(Long.valueOf(id)).orElseThrow(IllegalArgumentException::new);
        repository.delete(person);
    }

    public Person update(Person p){
        Person person = repository.findById(p.getId()).orElseThrow(IllegalArgumentException::new);
        person.setAddress(p.getAddress());
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        return repository.save(person);
    }
}
