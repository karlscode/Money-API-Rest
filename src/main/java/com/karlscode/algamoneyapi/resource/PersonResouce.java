package com.karlscode.algamoneyapi.resource;

import com.karlscode.algamoneyapi.event.ResourceCreateEvent;
import com.karlscode.algamoneyapi.model.Person;
import com.karlscode.algamoneyapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonResouce {

	@Autowired
	PersonService personService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Person> findAll() {
		return personService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person person = personService.getById(id);
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public ResponseEntity<Person> savePerson(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person savePerson = personService.save(person);
		publisher.publishEvent(new ResourceCreateEvent(this, response, savePerson.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savePerson);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @Valid @RequestBody Person person) {
		Person update = personService.update(id, person);
		return ResponseEntity.accepted().body(update);
	}
	
	@PutMapping("/{id}/active")
	public ResponseEntity<Void> updatePersonActive(@PathVariable Long id, @RequestBody Boolean active) {
		personService.updatePersonActive(id, active);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
