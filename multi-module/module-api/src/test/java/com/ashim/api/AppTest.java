package com.ashim.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private App app;

	@Test
	public void contextLoads() {
		assertThat(this.app).isNotNull();
	}

	@Test
	public void testApi() {
		String apiResult = this.restTemplate.getForObject("http://localhost:" + this.port, String.class);
		assertThat(apiResult).isEqualTo("Welcome to Multi-Module Project");
	}
}
