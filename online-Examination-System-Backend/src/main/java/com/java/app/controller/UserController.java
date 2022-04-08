package com.java.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.app.db.UserRepository;
import com.java.app.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/token")
	public List<User> getUsers1() {
		return userRepository.findAll();
	}
	
	@PutMapping("/update")
	public User updateUsers(@RequestBody User user) {
		User existingUser = (User) userRepository.getUserByUsername(user.getUsername());
		System.out.println(user);
		if(existingUser == null) {
			System.out.println("User Not Found");
			return userRepository.save(user);
		}else {
			//existingUser.setUsername(user.getUsername());
			existingUser.setPassword(user.getPassword());
			userRepository.save(existingUser);
		}
		return user;
		
	}

}
