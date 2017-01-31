package com.busyflights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BusyFlightsNotFoundException extends RuntimeException {

	public BusyFlightsNotFoundException(String message) {
		super(message);
	}
}