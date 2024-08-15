package com.mkd.crud.services;

import java.util.List;

import com.mkd.crud.models.User;

public interface UserService {
	
	User creerUser(User user);
	
	User modifierUser(Long id, User user);
	
	List<User> listerUser();
	
	String supprimerUser(Long id);
	

}
