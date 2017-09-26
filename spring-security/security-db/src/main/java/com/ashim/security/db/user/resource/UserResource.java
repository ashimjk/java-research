package com.ashim.security.db.user.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashim.security.db.user.model.User;
import com.ashim.security.db.user.repo.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	private UserRepository repo;

	@GetMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getUsers() {
		return this.repo.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getUserById(@PathVariable int id) {
		return this.repo.findOne(id);
	}

	@GetMapping("/current")
	public User getUser(@AuthenticationPrincipal UserDetails details) {
		String username = details.getUsername();

		Optional<User> user = this.repo.findByUsername(username);

		return user.isPresent() ? user.get() : null;
	}

}
