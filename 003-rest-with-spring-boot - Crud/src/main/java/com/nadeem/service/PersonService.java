package com.nadeem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.nadeem.converters.EntityConverter;
import com.nadeem.model.Person;
import com.nadeem.repository.PersonRepository;
import com.nadeem.vo.v1.PersonVo;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public PersonVo createPerson(PersonVo person) {
		Person entity = EntityConverter.parseObject(person, Person.class);
		return EntityConverter.parseObject(personRepository.save(entity), PersonVo.class);
	}

	public void deleteById(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID" + id));
		personRepository.delete(person);
	}

	public PersonVo findById(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID" + id));
		return EntityConverter.parseObject(entity, PersonVo.class);
	}

	public PersonVo updatePerson(PersonVo p) {
		Person person = personRepository.findById(p.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID" + p.getId()));
		person.setFirstName(p.getFirstName());
		person.setLastName(p.getLastName());
		person.setAddress(p.getAddress());
		person.setGender(p.getGender());
		return EntityConverter.parseObject(personRepository.save(person), PersonVo.class);
	}

	public List<PersonVo> findAll() {
		return EntityConverter.parseListObject(personRepository.findAll(), PersonVo.class);
	}

}
