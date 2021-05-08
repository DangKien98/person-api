package com.kien.personapi.service;

import com.kien.personapi.models.Person;
import com.kien.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("person")
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent())
            return person.get();

        return null;
    }

    public List<Person> getPersonByAge(int age) {
        return personRepository.getPersonByAgeAfter(age);
    }

    public Person updatePerson(Long id, Person person) {
        Person personFound = getById(id);
        if(personFound != null || id.equals(personFound.getId()))
            return personRepository.save(person);

        return null;
    }

    public Person deletePerson (Long id) {
        Person personFound = getById(id);
        if(personFound != null) {
            personRepository.delete(personFound);
            return personFound;
        }
        return null;
    }
}
