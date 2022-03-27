package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Model.User;
import com.example.demo.Model.UserAddress;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest 

public class UserTest {
	@MockBean
	private UserRepo repo;
	
	@Autowired
	private UserService service;
	
	@Test
	public void addUser() {
		UserAddress address = new UserAddress("IND","TS","HYD","001122");
		User insert = new User("ram","ram@gmail.com",1234567890,"ram009",address);
		when(repo.save(insert)).thenReturn(insert);
		assertEquals(insert, service.addUser(insert));
		
	}
	@Test
	
	public void getUserTest() {
		String name = "java";
		String password = "java009";
		UserAddress address = new UserAddress("IND","TS","HYD","001122");
//		when(repo.findByNameAndPassword(name,password)).thenReturn(Stream.of(new User (UserId,"java", "java@gmail.com",
//				1234567890,"java009","IND","TS","ADB","777")).collect(Collectors.toList()));
		//assertEquals(insert,service.userlogin(name,password).save());
		User insert = new User("ram","ram@gmail.com",1212345678,"ram009",address);
		when(repo.findByNameAndPassword(name,password)).thenReturn(insert);
		assertEquals(insert, service.userlogin(name,password));
		
		
	}

}
