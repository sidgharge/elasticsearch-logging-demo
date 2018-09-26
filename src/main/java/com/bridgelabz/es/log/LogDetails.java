package com.bridgelabz.es.log;

import java.time.LocalDateTime;

public class LogDetails {

	private String message;

	private LocalDateTime occuredAt = LocalDateTime.now();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getOccuredAt() {
		return occuredAt;
	}

	public void setOccuredAt(LocalDateTime occuredAt) {
		this.occuredAt = occuredAt;
	}

}
