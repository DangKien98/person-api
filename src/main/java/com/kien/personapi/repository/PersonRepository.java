package com.kien.personapi.repository;

import com.kien.personapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.age > :age")
    List<Person> getPersonByAgeAfter(int age);



}
