package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.ServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private ServiceImpl service;

	@GetMapping("/registration")
	public String getRegistrationPage() {
		return "registration";
	}
	
	@PostMapping("/addUser")
	public String addUser(User user) {
		service.saveUser(user);
		return "home";
	}
	
	
}
