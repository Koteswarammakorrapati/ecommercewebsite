package com.ecommerce.ecommercewebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommercewebsite.Service.UserService;
import com.ecommerce.ecommercewebsite.dto.UserResponse;
import com.ecommerce.ecommercewebsite.entity.User;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	//create user
	@PostMapping("/register")
	public UserResponse createUser(@RequestBody User user) {
		User saveuser= service.createUser(user);
		return new UserResponse(saveuser.getId(),saveuser.getName(),saveuser.getEmail());
	}
	//login
	@PostMapping("/login")
	public UserResponse loginUser(@RequestBody User user) {
		User loginuser= service.LoginUser(user.getEmail(), user.getPassword());
	     return new UserResponse(loginuser.getId(), loginuser.getName(), loginuser.getEmail());
	}
}
