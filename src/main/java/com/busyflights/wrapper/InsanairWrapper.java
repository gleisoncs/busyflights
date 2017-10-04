package com.busyflights.wrapper;

import java.util.function.Function;

import com.busyflights.helper.RequestConverter;
import com.busyflights.helper.ResponseConverter;
import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.InsanairRequest;
import com.busyflights.model.InsanairResponse;

public class InsanairWrapper extends Wrapper {

	public String getUrl() {
		return "http://localhost:8090/insanair/search";
	}

	@Override
	public InsanairRequest convertToRequest(BusyFlightsRequest request) {
		return RequestConverter.toRyanairRequest(request);
	}

	@Override
	public Class<InsanairResponse[]> getResponseType() {
		return InsanairResponse[].class;
	}

	@Override
	public Function<InsanairResponse, BusyFlightsResponse> getResponse() {
		return ResponseConverter.mapInsanairResponseToBusyFlightsResponse;
	}
}