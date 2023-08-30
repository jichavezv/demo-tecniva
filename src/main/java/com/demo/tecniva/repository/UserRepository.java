package com.demo.tecniva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tecniva.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
