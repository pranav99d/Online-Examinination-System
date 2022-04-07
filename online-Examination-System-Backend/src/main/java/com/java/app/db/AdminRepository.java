package com.java.app.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.app.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	

}
