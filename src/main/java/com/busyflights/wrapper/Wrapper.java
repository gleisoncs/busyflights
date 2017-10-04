package com.busyflights.wrapper;

import java.util.function.Function;

import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.Request;
import com.busyflights.model.Response;

public abstract class Wrapper<T> {
	public abstract String getUrl();

	public abstract Request convertToRequest(BusyFlightsRequest request);

	public abstract Class<T> getResponseType();

	public abstract Function<Response, Response> getResponse();
}
