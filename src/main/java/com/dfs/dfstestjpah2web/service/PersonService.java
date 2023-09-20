package com.dfs.dfstestjpah2web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.dfstestjpah2web.dao.PersonRepository;
import com.dfs.dfstestjpah2web.entity.Person;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> createPersons(List<Person> persons) {
		return personRepository.saveAll(persons);
	}

	public Person getPersonById(int id) {
		return personRepository.findById(id).orElse(null);
	}

	public List<Person> getPersons() {
		return personRepository.findAll();
	}
	
	public Person updatePerson(Person person) {
		Person oldPerson=null;
		Optional<Person> optionalperson=personRepository.findById(person.getUserId());
		if(optionalperson.isPresent()) {
			oldPerson=optionalperson.get();
			oldPerson.setName(person.getName());
			oldPerson.setEmail(person.getEmail());
			personRepository.save(oldPerson);
		}else {
			// return new Person();
		}
		return oldPerson;
	}
	
	public String deletePersonById(int id) {
		personRepository.deleteById(id);
		return "User got deleted";
	}

}