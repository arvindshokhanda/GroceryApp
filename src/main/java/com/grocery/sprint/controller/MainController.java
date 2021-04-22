package com.grocery.sprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.sprint.beans.Holder;
import com.grocery.sprint.beans.User;
import com.grocery.sprint.service.UserServiceImpl;

@RestController
@RequestMapping("/Grocery")
public class MainController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> addUser(@RequestBody Holder hold)
	{
		User user=userService.addUser(hold);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(path="login/{loginId}/{password}", consumes="application/json", produces="application/json") 
	public ResponseEntity<User> login(@PathVariable String loginId, @PathVariable String password) 
	{ 
		User user=userService.login(loginId, password);
	 
	 if(user!=null) 
		 return new ResponseEntity<User>(user, HttpStatus.OK); 
	 else
		 return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND); 
	 }
	
	@PutMapping(path="/change-password/{loginId}/{oldPassword}/{newPassword}", consumes="application/json", produces="application/json")
	public ResponseEntity<String> changePassword(@PathVariable String loginId, @PathVariable String oldPassword, @PathVariable String newPassword)
	{
		boolean status=userService.changePassword(loginId, oldPassword, newPassword);
		
		if(status)
			return new ResponseEntity<String>("Password changed successfully.", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Password not changed.", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="/forgot-password/{loginId}/{answer}/{newPassword}", consumes="application/json", produces="application/json")
	public ResponseEntity<String> forgotPassword(@PathVariable String loginId, @PathVariable String answer, @PathVariable String newPassword)
	{
		boolean status=userService.forgotPassword(loginId, answer, newPassword);
		
		if(status)
			return new ResponseEntity<String>("Password changed successfully.", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Password not changed.", HttpStatus.NOT_FOUND);
	}
	

}
