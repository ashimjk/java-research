package com.ashim.course.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping()
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@GetMapping(value = "/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@PostMapping()
	public void insertTopic(@RequestBody Topic topic) {
		topicService.insertTopic(topic);
	}

	@PutMapping(value = "/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.delete(id);
	}
}
