package com.khairenncode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@RestController
public class MaybankAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaybankAssignmentApplication.class, args);
	}

	@GetMapping("/order")
	public Person greet() {
		Person lmao = new Person("Lai", 25, 189, 82);

		return lmao;
	}

	private record Person(String name, int age, int height, int weight) {};

}
