package com.learnSphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entities.Users;
//responsible for defining methods to perform crud operation
public interface UsersRepository extends JpaRepository<Users, Integer>{
	Users findByEmail(String email);
	
	boolean existsByEmail(String email);
}
