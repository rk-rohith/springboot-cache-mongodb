package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@CachePut(value = "persons", key = "#person.firstName")
	@PostMapping("/create")
	public Person createPerson(@RequestBody Person person) {
		System.out.println("Creating record");
		return personService.createPerson(person);
	}
	
	@Cacheable(value = "persons")
	@GetMapping("/getAllPerson")
	public List<Person> getAllPerson() {
		System.out.println("Getting all records");
		return personService.getAllPerson();
	}

	@Cacheable(value = "persons", key = "#firstName")
	@GetMapping("/getPerson/{firstName}")
	public Person getPerson(@PathVariable String firstName) {
		System.out.println("Getting record");
		return personService.getPerson(firstName);
	}
	
	@CachePut(value = "persons", key = "#person.firstName")
	@PutMapping("/update")
	public Person updatePerson(@RequestBody Person person){
		System.out.println("Updating record");
		return personService.updatePerson(person);
	}
	
	@CacheEvict(value = "persons", key = "#id")
	@DeleteMapping("/delete/{id}")
	public String deletePerson(@PathVariable String id) {
		System.out.println("Deleted the record");
		return personService.deletePerson(id);
	}
	
	@CacheEvict(value = "persons")
	@DeleteMapping("/deleteAll")
	public String deleteAllPerson() {
		return personService.deleteAllPerson();
	}
	
	@CacheEvict(value = "persons", allEntries=true)
	@GetMapping("/clearCache")
	public String clearAllcache() {
		return "All Data cleared successfully";
	}

}
