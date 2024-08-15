package com.mkd.crud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkd.crud.models.User;
import com.mkd.crud.services.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return userService.creerUser(user);
	}
	@GetMapping("/list")
	public List<User> ReadAllUser(){
		return userService.listerUser();
	}
	@PutMapping("/update/{id}")
	public User update(@PathVariable Long id,@RequestBody User user) {
		return userService.modifierUser(id, user);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return userService.supprimerUser(id);
	}
}
