package com.nadeem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadeem.model.Person;
import com.nadeem.service.PersonService;
import com.nadeem.vo.v1.PersonVo;

@RestController
@RequestMapping("/person/v1")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/listPersons")
	public List<PersonVo> findAll() {
		return personService.findAll();
	}

	@GetMapping("/{id}")
	public PersonVo finById(@PathVariable("id") Long id) {
		return personService.findById(id);
	}

	@PostMapping("createPerson")
	public PersonVo createPerson(@RequestBody PersonVo person) {
		return personService.createPerson(person);
	}

	@PutMapping("updatePerson")
	public PersonVo updatePerson(@RequestBody PersonVo person) {
		return personService.updatePerson(person);
	}

	@DeleteMapping("deletePerson/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		personService.deleteById(id);
	}
}
