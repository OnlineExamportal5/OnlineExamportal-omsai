package com.example.demo.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo repo;
	public User addUser(User u)
{
		User user=repo.save(u);
		return user;
		
}



  public User userlogin(String name, String password) {
	  User user=repo.findByNameAndPassword(name,password);
  
  return user; 
  }
  
  
  
  public void updateUserByEmailId(User u) 
  {
	  repo.save(u); 
	  }
  
  public Optional<User> findByEmailId(String emailId)
  {
	  return repo.findByEmailId(emailId);
	  }
 
  
}

	
	








