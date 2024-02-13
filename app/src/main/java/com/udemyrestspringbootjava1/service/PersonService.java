package com.udemyrestspringbootjava1.service;

import com.udemyrestspringbootjava1.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<Person> findAll(){
        return this.getMockListPerson();
    }

    public Person findById(String id){
        Person p = new Person();
        p.setId(Long.valueOf(id));
        p.setFirstName("NAME");
        p.setLastName("LASTNAME");
        p.setAddress("Endereço 1");
        return p;
    }

    public Person create(Person p){
        p.setId(Long.valueOf(100));
        return p;
    }

    public void delete(String id){

    }


    private List<Person> getMockListPerson(){
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            int j = i+1;
            Person p = new Person();
            p.setId(Long.valueOf(j));
            p.setFirstName("NAME " + j);
            p.setLastName("LASTNAME " + j);
            p.setAddress("ENDEREÇO " + j);
            list.add(p);
        }
        return list;
    }
}
