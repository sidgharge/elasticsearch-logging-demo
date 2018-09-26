package com.bridgelabz.es.log.exceptions.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.es.log.LogDetails;
import com.bridgelabz.es.log.services.EsService;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private EsService esService;

	@ExceptionHandler(value = Exception.class)
	public String handle(Exception e) throws IOException {
		LogDetails details = new LogDetails();
		details.setMessage(e.getMessage());
		
		esService.save(details);
		
		return e.getMessage();
	}
}
