package com.karlscode.algamoneyapi.service;

import com.karlscode.algamoneyapi.model.User;
import com.karlscode.algamoneyapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getById(Long id) {
		return findUserById(id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User update(Long id, User user) {
		User saveUser = findUserById(id);

		BeanUtils.copyProperties(user, saveUser, "id");
		return userRepository.save(saveUser); 
	}
	
	public void delete(Long id) {
		findUserById(id);
		userRepository.deleteById(id);
	}
	
	private User findUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
}
