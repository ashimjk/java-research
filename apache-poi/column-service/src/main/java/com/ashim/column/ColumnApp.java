package com.ashim.column;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashim.column.dto.Column;
import com.ashim.column.service.ColumnService;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SpringBootApplication
public class ColumnApp {

	@Autowired
	private ColumnService service;

	@Bean
	public ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_EMPTY);

		return mapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(ColumnApp.class, args);
	}

	@GetMapping(value = "/columns")
	public Map<Integer, List<Column>> getColumns() {
		return this.service.getColumns();
	}

	@GetMapping(value = "/columns/{level}")
	public List<Column> getColumns(@PathVariable int level) {
		return this.service.getColumns().get(level);
	}

}
