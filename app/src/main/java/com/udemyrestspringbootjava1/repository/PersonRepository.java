package com.udemyrestspringbootjava1.repository;

import com.udemyrestspringbootjava1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
