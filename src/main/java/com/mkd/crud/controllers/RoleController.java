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

import com.mkd.crud.models.Role;
import com.mkd.crud.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	private final RoleService roleService ;
	public RoleController(RoleService roleService) {
		this.roleService=roleService;
	}
	
	@PostMapping("/create")
	public Role create(@RequestBody Role role) {
		return roleService.creerRole(role);
	}
	
	@PutMapping("/update/{role_id}")
	public Role update(@PathVariable Long role_id, @RequestBody Role role) {
		return roleService.modifierRole(role_id, role);
	}
	@GetMapping("/read")
	public List<Role> readAllRole(){
		return roleService.afficherListRole();
	}
	@DeleteMapping("/delete/{role_id}")
	public String delete(@PathVariable Long role_id) {
		return roleService.supprimer(role_id);
	}

}
