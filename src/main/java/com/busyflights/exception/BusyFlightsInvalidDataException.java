package com.busyflights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusyFlightsInvalidDataException extends RuntimeException {

	public BusyFlightsInvalidDataException(String message) {
		super(message);
	}
}