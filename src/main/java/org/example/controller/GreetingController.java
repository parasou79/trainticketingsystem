package org.example.controller;

import java.util.Map;

import org.example.model.Train;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Train greetingById(@PathVariable int id) {
		return new Train(1, "Welcome");
	}

	@GetMapping("")
	public Train greeting(@RequestParam(value="name", defaultValue="me") String name) {
		return new Train(1, name);
	}
}
