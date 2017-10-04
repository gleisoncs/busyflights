package com.busyflights.wrapper;

import java.util.function.Function;

import com.busyflights.helper.RequestConverter;
import com.busyflights.helper.ResponseConverter;
import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.CrazyAirRequest;
import com.busyflights.model.CrazyAirResponse;

public class CrazyWrapper extends Wrapper {

	public CrazyWrapper() {

	}

	public String getUrl() {
		return "http://localhost:8090/crazyair/search";
	}

	@Override
	public CrazyAirRequest convertToRequest(BusyFlightsRequest request) {
		return RequestConverter.toCrazyAirRequest(request);
	}

	@Override
	public Class<CrazyAirResponse[]> getResponseType() {
		return CrazyAirResponse[].class;
	}

	@Override
	public Function<CrazyAirResponse, BusyFlightsResponse> getResponse() {
		return ResponseConverter.mapCrazyAirResponseToBusyFlightsResponse;
	}
}