package org.example.controller;

import java.util.List;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User usr) {
		return userService.create(usr.getFname(), usr.getLname(), usr.getEmail());
	}

	@GetMapping(value="/{uid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User fetch(@PathVariable int uid) {
		User user = userService.findById(uid);
		return user;
	}

	@GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> fetchAll() {
		List<User> users = userService.find(null);
		return users;
	}

	@PostMapping(value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> fetchFiltered(@RequestBody User user) {
		List<User> users = userService.find(user);
		return users;
	}
}
