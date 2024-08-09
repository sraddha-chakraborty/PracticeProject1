package com.springboot.app.practicev1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	// GET HTTP Method
	// http://localhost:8080/helloWorld
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello World!";
	}
}
