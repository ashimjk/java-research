package com.ashim.security.basic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashim.security.basic.user.resource.UserResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityBasicAppTests {

	@Autowired
	private UserResource userResource;

	@Test
	public void contextLoads() {
		assertThat(this.userResource).isNotNull();
	}

}
