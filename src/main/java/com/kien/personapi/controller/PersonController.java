package com.kien.personapi.controller;

import com.kien.personapi.models.Person;
import com.kien.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.getById(id);
    }

    @GetMapping("/searchAge/{age}")
    public List<Person> getPersonByAge(@PathVariable("age") int age) {
        return personService.getPersonByAge(age);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public Person deletePerson(@PathVariable("id") Long id) {
        return personService.deletePerson(id);
    }
}
