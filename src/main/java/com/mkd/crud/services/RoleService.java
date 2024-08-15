package com.mkd.crud.services;

import java.util.List;

import com.mkd.crud.models.Role;

public interface RoleService {
	
	public Role creerRole(Role role);
	public Role modifierRole(Long role_id,Role role);
	public List<Role> afficherListRole();
	public String supprimer(Long role_id);

}
