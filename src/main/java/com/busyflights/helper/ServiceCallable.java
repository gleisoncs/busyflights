package com.busyflights.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.web.client.RestTemplate;

public class ServiceCallable<T> implements Callable<T> {

	String url;
	Object request;
	Class<T> responseType;
	Map<String, String> vars = new HashMap<>();
	
	public ServiceCallable(String url, Object request, Class<T> responseType ) {
		super();
		this.url = url;
		this.request = request;
		this.responseType = responseType;
	}

	@Override
	public T call() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		T result = restTemplate.postForObject(url, request, responseType, vars);
		return result;
	}
}