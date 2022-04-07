package com.java.app.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUsername(String username);

}
