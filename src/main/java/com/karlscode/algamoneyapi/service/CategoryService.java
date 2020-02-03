package com.karlscode.algamoneyapi.service;

import com.karlscode.algamoneyapi.model.Category;
import com.karlscode.algamoneyapi.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	public Category getById(Long id) {
		return findCategoryById(id);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public Category update(Long id, Category category) {
		Category saveCategory = findCategoryById(id);

		BeanUtils.copyProperties(category, saveCategory, "id");
		return categoryRepository.save(saveCategory);
	}

	public void delete(Long id) {
		findCategoryById(id);
		categoryRepository.deleteById(id);
	}

	private Category findCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
