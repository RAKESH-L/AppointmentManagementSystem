package com.spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.entity.User;
import com.spring.jpa.entity.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User saveUser(User user) {
		return registrationRepository.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return registrationRepository.findByEmailId(email);
	}
	public User fetchUserByEmailIdAndPasswordAndUserType(String email, String password, String userType) {
		return registrationRepository.findByEmailIdAndPasswordAndUserType(email, password, userType);
	}
	
	
}
