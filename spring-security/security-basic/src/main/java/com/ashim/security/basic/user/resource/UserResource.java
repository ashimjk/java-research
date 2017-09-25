package com.ashim.security.basic.user.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashim.security.basic.user.model.User;
import com.ashim.security.basic.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping()
	public List<User> getUsers() {
		return this.service.getUsers();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getUserById(@PathVariable int id) {
		return this.service.getUserById(id);
	}

	@GetMapping("/current")
	public User getUser(@AuthenticationPrincipal UserDetails details) {
		String userName = details.getUsername();

		return this.service.getUserByName(userName);
	}

}