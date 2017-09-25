package com.ashim.security.basic;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ashim.security.basic.user.model.User;
import com.ashim.security.basic.user.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SecurityTest {

	@MockBean
	private UserService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void credenticalWrong_ShouldReturnNotAuthorize() throws Exception {

		when(this.service.getUsers())
				.thenReturn(Arrays.asList(new User(1, "admin", "admin"), new User(2, "user", "user")));

		this.mockMvc
				.perform(get("http://localhost:8082/api/users"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	public void credenticalOk_ShouldReturnOk() throws Exception {

		when(this.service.getUsers())
				.thenReturn(Arrays.asList(new User(1, "admin", "admin"), new User(2, "user", "user")));

		this.mockMvc
				.perform(get("http://localhost:8082/api/users")
						.with(user("admin")
								.password("admin")))

				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("[*].id").isNotEmpty())
				.andExpect(jsonPath("[*].username").isNotEmpty())
				.andExpect(jsonPath("[*].password").isNotEmpty());
	}

	@Test
	public void allowAccess_ShouldReturnOk() throws Exception {

		when(this.service.getUserById(1))
				.thenReturn(new User(1, "admin", "admin"));

		this.mockMvc
				.perform(get("http://localhost:8082/api/users/1")
						.with(user("user")
								.password("user")))

				.andExpect(status().isOk())
				.andExpect(jsonPath("id").isNotEmpty())
				.andExpect(jsonPath("username").isNotEmpty())
				.andExpect(jsonPath("password").isNotEmpty());

	}
}
