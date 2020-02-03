package com.karlscode.algamoneyapi.resource;

import com.karlscode.algamoneyapi.event.ResourceCreateEvent;
import com.karlscode.algamoneyapi.model.User;
import com.karlscode.algamoneyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResouce {

	@Autowired
	UserService userService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<User> findAll() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.getById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user, HttpServletResponse response) {
		User saveUser = userService.save(user);
		publisher.publishEvent(new ResourceCreateEvent(this, response, saveUser.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
		User update = userService.update(id, user);
		return ResponseEntity.accepted().body(update);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
