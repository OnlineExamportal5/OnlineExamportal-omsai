package com.example.demo.UserRestController;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.UserResourceNotFoundException;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/UserLoginPage")
public class UserLogin {
	@Autowired
	UserService service;

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@Validated @RequestBody User u) {
		// @SuppressWarnings("unused")
		User user = service.addUser(u);

		return new ResponseEntity<String>("Registration Done Successfully", HttpStatus.OK);
	}

	@GetMapping("/UserLogin")
	public ResponseEntity<String> checkUser( @RequestBody User u) {
		String status = null;
		User user = service.userlogin(u.getName(), u.getPassword());
		if (Objects.nonNull(user)) {
			status = "welcome to the portal";
		} else {
			throw new UserResourceNotFoundException("Invaild Credentials");
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	@PutMapping("/forgotPassword")
	public ResponseEntity<String> updateUserByEmailId(@RequestBody User u) {
		String status = null;
		Optional<User> obj = service.findByEmailId(u.getEmailId());

		if (obj.isPresent()) {
			obj.get().setPassword(u.getPassword());
			service.updateUserByEmailId(obj.get());
			status = "Password Changed Successfully";
		} else {
			throw new UserResourceNotFoundException("Provide Valid EmailId");

		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
