package com.java.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.app.db.AdminRepository;
import com.java.app.model.Admin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/get")
	public List<Admin> getUsers() {
		return adminRepository.findAll();
	}

	@PostMapping("/token")
	public ResponseEntity<?> loginUser(@RequestBody Admin admin) {
		Admin existingAdmin = (Admin) adminRepository.getUserByUsername(admin.getUsername());
		System.out.println(admin);
		if(existingAdmin == null) {
			System.out.println("User Not Found");
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}else if(existingAdmin.getPassword().equals(admin.getPassword()))
		{
			return ResponseEntity.ok(admin);
		}
		else {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
<<<<<<< HEAD
	}
	
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin) {
		Admin existingAdmin = (Admin) adminRepository.getUserByUsername(admin.getUsername());
		System.out.println(admin);
		if(existingAdmin == null) {
			System.out.println("Admin Not Found");
			//return adminRepository.save(admin);
		}else {
			existingAdmin.setPassword(admin.getPassword());
			adminRepository.save(existingAdmin);
		}
		return admin;
		
	}
<<<<<<< HEAD
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin) {
		Admin existingAdmin = (Admin) adminRepository.getUserByUsername(admin.getUsername());
		System.out.println(admin);
		if(existingAdmin == null) {
			System.out.println("User Not Found");
			return adminRepository.save(admin);
		}else {
			existingAdmin.setPassword(admin.getPassword());
			adminRepository.save(existingAdmin);
		}
		return admin;
		
	}
=======
>>>>>>> 6ca6f6cd2f09dddab64d0eadc7de482c2c829256
=======
	}
	
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin) {
		Admin existingAdmin = (Admin) adminRepository.getUserByUsername(admin.getUsername());
		System.out.println(admin);
		if(existingAdmin == null) {
			System.out.println("Admin Not Found");
			//return adminRepository.save(admin);
		}else {
			existingAdmin.setPassword(admin.getPassword());
			adminRepository.save(existingAdmin);
		}
		return admin;
		
	}
>>>>>>> 6ca6f6cd2f09dddab64d0eadc7de482c2c829256
}
