package com.mkd.crud.services;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.mkd.crud.models.User;
import com.mkd.crud.repositories.UserRepository;

import lombok.AllArgsConstructor;


@Service
/* @AllArgsConstructor */
public class UserServiceImp implements UserService {
	
	private final UserRepository userRepository;
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User creerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User modifierUser(Long id, User user) {
		return userRepository.findById(id).map(existingUser -> {
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			return userRepository.save(existingUser);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
	}
	@Override
	public List<User> listerUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public String supprimerUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "user supprimer avec succés";
	}

}
