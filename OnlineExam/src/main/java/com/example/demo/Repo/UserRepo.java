package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
	
	
	
	  User findByNameAndPassword(String name, String password);
	  
	  Optional<User> findByEmailId(String emailId);
	 
	 
	 
    	
	} 


