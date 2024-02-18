package com.udemyrestspringbootjava1.service;

import com.udemyrestspringbootjava1.dto.PersonDTO;
import com.udemyrestspringbootjava1.exception.ResourceNotFoundException;
import com.udemyrestspringbootjava1.mapper.ObjectMapper;
import com.udemyrestspringbootjava1.model.Person;
import com.udemyrestspringbootjava1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll(){
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(String id){
        var entity = repository.findById(Long.valueOf(id)).
                orElseThrow(() -> new ResourceNotFoundException("Person ID not found"));
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO p){
        var entity = ObjectMapper.parseObject(p, Person.class);
        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(String id){
        Person person = repository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Person ID not found"));
        repository.delete(person);
    }

    public PersonDTO update(PersonDTO p){
        Person person = repository.findById(p.getId()).orElseThrow(() -> new ResourceNotFoundException("Person ID not found"));
        person.setAddress(p.getAddress());
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        return ObjectMapper.parseObject(repository.save(person), PersonDTO.class);
    }
}
