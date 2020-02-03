package com.karlscode.algamoneyapi.resource;

import com.karlscode.algamoneyapi.event.ResourceCreateEvent;
import com.karlscode.algamoneyapi.model.Category;
import com.karlscode.algamoneyapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResouce {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@CrossOrigin
	@GetMapping
	public List<Category> findAll() {
		return categoryService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = categoryService.getById(id);
		return ResponseEntity.ok(category);
	}
	
	@PostMapping
	public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category, HttpServletResponse response) {
		Category saveCategory = categoryService.save(category);
		publisher.publishEvent(new ResourceCreateEvent(this, response, saveCategory.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @Valid @RequestBody Category category) {
		Category update = categoryService.update(id, category);
		return ResponseEntity.accepted().body(update);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
