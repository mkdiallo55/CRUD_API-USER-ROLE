package com.mkd.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkd.crud.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
