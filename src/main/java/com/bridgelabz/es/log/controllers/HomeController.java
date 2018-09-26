package com.bridgelabz.es.log.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.es.log.entities.Person;

@RestController
@RequestMapping("/persons")
public class HomeController {

	@PostMapping
	public void addPerson(Person person) {
		System.out.println(person);
	}
	
	@GetMapping
	public Person getPerson() {
		Person person = new Person("Sid", 22, 25000);
	
		System.out.println(person);
		
		return person;
	}
	
	@GetMapping("/error")
	public void getError() {
		throw new RuntimeException("Exception " + UUID.randomUUID().toString());
	}
}
