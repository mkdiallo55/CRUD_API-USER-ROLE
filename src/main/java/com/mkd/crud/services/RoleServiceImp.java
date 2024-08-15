package com.mkd.crud.services;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.mkd.crud.models.Role;
import com.mkd.crud.repositories.RoleRepository;

@Service
public class RoleServiceImp  implements RoleService{
	
	private final RoleRepository roleRepository;
	public RoleServiceImp(RoleRepository roleRepository) {
		this.roleRepository=roleRepository;
	}

	@Override
	public Role creerRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public Role modifierRole(Long role_id, Role role) {
		// TODO Auto-generated method stub
		return roleRepository.findById(role_id).map(roleExisting->{
			roleExisting.setName(role.getName());
			return roleRepository.save(roleExisting);
		}).orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + role_id));
	}

	@Override
	public List<Role> afficherListRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public String supprimer(Long role_id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(role_id);
		return "Role Supprimer avec succes";
	}

}
