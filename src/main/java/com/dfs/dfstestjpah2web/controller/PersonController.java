package com.dfs.dfstestjpah2web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dfs.dfstestjpah2web.entity.Person;
import com.dfs.dfstestjpah2web.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;

	@PostMapping("/addPerson")
	public Person addPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}

	@PostMapping("/addPersons")
	public List<Person> addPerson(@RequestBody List<Person> persons) {
		return personService.createPersons(persons);
	}

	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
	}

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personService.getPersons();
	}
	
	@PutMapping("/updateperson")
	public Person updatePerson(@RequestBody Person user) {
		return personService.updatePerson(user);
	}

	@DeleteMapping("/person/{id}")
	public String deletePerson(@PathVariable int id) {
		return personService.deletePersonById(id);
	}
}
