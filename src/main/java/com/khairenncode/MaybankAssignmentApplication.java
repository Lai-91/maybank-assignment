package com.khairenncode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@RestController
public class MaybankAssignmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(MaybankAssignmentApplication.class, args);
	}

}
