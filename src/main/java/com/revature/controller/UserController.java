package com.revature.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

/**
 * 
 * @author teresafitzgerald
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserService uServ;

	@Autowired
	public UserController(UserService serv) {
		this.uServ = serv;
	}

	@PostMapping(value = "/register")
	public ResponseEntity<User> registerUser(@RequestBody LinkedHashMap<String, String> uMap) {
		User user = uServ.registerUser(uMap.get("username"), uMap.get("password"));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<User> loginUser(@RequestBody LinkedHashMap<String, String> uMap) {
		User user = uServ.loginUsername(uMap.get("username"), uMap.get("password"));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/logout")
	public ResponseEntity<String> logoutUser(@RequestBody LinkedHashMap<String, String> uMap) {
		boolean result = uServ.logoutUsername(uMap.get("username"));
		return new ResponseEntity<String>(result + "", HttpStatus.OK);
	}

	@PostMapping(value = "/searchUser")
	public ResponseEntity<User> searchUser(@RequestBody LinkedHashMap<String, String> uMap) {
		User retrieved = uServ.searchUsers(uMap.get("username"));
		return new ResponseEntity<User>(retrieved, HttpStatus.OK);
	}

	@GetMapping(value = "/loggedOn")
	public ResponseEntity<List<User>> loggedOn() {
		List<User> uList = uServ.getLoggedOnUsers();
		return new ResponseEntity<List<User>>(uList, HttpStatus.OK);
	}

}
