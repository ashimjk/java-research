package com.ashim.security.db.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashim.security.db.user.model.CustomUserDetails;
import com.ashim.security.db.user.model.User;
import com.ashim.security.db.user.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> users = this.repo.findByUsername(username);

		users.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return users.map(CustomUserDetails::new).get();
	}

}
