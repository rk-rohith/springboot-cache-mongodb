package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPerson(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public String deletePerson(String id) {
        personRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public String deleteAllPerson() {
        personRepository.deleteAll();
        return "Deleted all Person records Success fully";
    }
}
