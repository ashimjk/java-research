package com.ashim.security.db;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ashim.security.db.user.model.Role;
import com.ashim.security.db.user.model.User;
import com.ashim.security.db.user.repo.RoleRepository;
import com.ashim.security.db.user.repo.UserRepository;

@SpringBootApplication
public class SecurityDbApplication {

	@Bean
	CommandLineRunner insertUser(UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
		return args -> {
			Arrays.asList(
					new Role(1, "ADMIN"),
					new Role(2, "USER"))
					.stream()
					.map(user -> {
						System.out.println(user);
						return user;
					})
					.forEach(roleRepo::save);

			Arrays.asList(
					new User(1, "admin", encoder.encode("admin"), true, Arrays.asList(new Role(1, "ADMIN"))),
					new User(2, "user", encoder.encode("user"), true, Arrays.asList(new Role(2, "USER"))))
					.stream()
					.map(user -> {
						System.out.println(user);
						return user;
					})
					.forEach(userRepo::save);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityDbApplication.class, args);
	}
}
