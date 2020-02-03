package com.karlscode.algamoneyapi.service;

import com.karlscode.algamoneyapi.model.Person;
import com.karlscode.algamoneyapi.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Person getById(Long id) {
		return findPersonById(id);
	}
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public Person update(Long id, Person person) {
		Person savePerson = findPersonById(id);

		BeanUtils.copyProperties(person, savePerson, "id");
		return personRepository.save(savePerson); 
	}
	
	public void delete(Long id) {
		findPersonById(id);
		personRepository.deleteById(id);
	}
	
	public void updatePersonActive(Long id, @Valid Boolean active) {
		Person savePerson = findPersonById(id);
		savePerson.setActive(active);
		personRepository.save(savePerson);
	}
	
	public Person findPersonById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
}
