package com.ashim.excel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashim.excel.service.ExcelColumn;
import com.ashim.excel.service.ExcelService;

/**
 * Boot the application, initialize bean and provide api for generating excel
 *
 * @author Ashim Jung Khadka <br>
 *         Created Date : Sep 24, 2017
 *
 */
@RestController
@SpringBootApplication
public class ExcelApp {

	@Autowired
	private ExcelService service;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ExcelApp.class, args);
	}

	/**
	 * Generate Excel
	 *
	 * @return List of Excel Column wrapped in Map
	 */
	@GetMapping(value = "/excel")
	public Map<Integer, List<ExcelColumn>> generateExcels() {
		return this.service.generateExcel();
	}

}
