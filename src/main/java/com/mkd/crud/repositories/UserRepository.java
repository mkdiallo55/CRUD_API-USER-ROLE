package com.mkd.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkd.crud.models.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
