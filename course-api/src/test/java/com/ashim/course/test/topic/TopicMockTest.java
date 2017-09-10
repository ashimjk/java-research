package com.ashim.course.test.topic;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import com.ashim.course.topic.Topic;
import com.ashim.course.topic.TopicService;

@RunWith(SpringRunner.class)
// @SpringBootTest
// @AutoConfigureMockMvc
@WebMvcTest
public class TopicMockTest {

	private String topicUrl = "/topics";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TopicService service;

	@Test
	public void shouldReturnTopicList() throws Exception {
		when(service.getAllTopics())
				.thenReturn(Arrays.asList(
						new Topic("spring", "Spring Framework",
								"Spring Framework Description")));

		this.mockMvc.perform(get(topicUrl))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("[*].id").isNotEmpty())
				.andExpect(jsonPath("[*].name").isNotEmpty())
				.andExpect(jsonPath("[*].description").isNotEmpty());
	}
}
