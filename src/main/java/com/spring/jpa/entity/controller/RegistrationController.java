package com.spring.jpa.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.User;
import com.spring.jpa.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj =  registrationService.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception("user with " +tempEmailId+ " is already exist");
			}
		}
		User userObj = null;
		userObj = registrationService.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		String tempUserType = user.getUserType();
		User userObj = null;
		if(tempEmailId != null && tempPass != null && tempUserType != null) {
			userObj = registrationService.fetchUserByEmailIdAndPasswordAndUserType(tempEmailId, tempPass, tempUserType);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
}
