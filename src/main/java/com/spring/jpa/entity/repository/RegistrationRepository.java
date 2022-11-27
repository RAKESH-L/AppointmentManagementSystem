package com.spring.jpa.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Long>{

	public User findByEmailId(String emailId);
	public User findByEmailIdAndPasswordAndUserType(String email, String password, String userType);
	
	@Query("select u from User u where u.id=?1")
	public User fetchUserRecord(long uid);
	
}

