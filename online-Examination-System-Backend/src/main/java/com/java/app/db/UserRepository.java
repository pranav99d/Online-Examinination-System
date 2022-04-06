package com.java.app.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
