package com.ashim.course.test.topic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TopicHttpTest {

	private static Logger logger = LoggerFactory.getLogger(TopicHttpTest.class);

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void topicShouldReturlList() throws Exception {

		String apiResult = this.restTemplate
				.getForObject("http://localhost:" + port + "/topics/", List.class)
				.toString();

		logger.info("---------------------------------");
		logger.info(apiResult);
		logger.info("---------------------------------");

		assertThat(apiResult).isNotNull();
	}
}
