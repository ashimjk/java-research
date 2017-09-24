package com.ashim.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceConfiguration.class, properties = "service.message=Hello")
public class MessageServiceTest {

	@Autowired
	private MessageService service;

	@Test
	public void contextLoads() {
		assertThat(this.service).isNotNull();
		assertThat(this.service.getMessage()).isEqualTo("Hello");
	}

}
