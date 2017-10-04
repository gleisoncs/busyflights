package com.busyflights.wrapper;

import java.util.function.Function;

import com.busyflights.helper.RequestConverter;
import com.busyflights.helper.ResponseConverter;
import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.ToughJetRequest;
import com.busyflights.model.ToughJetResponse;

public class ThoughWrapper extends Wrapper {

	public String getUrl() {
		return "http://localhost:8090/toughjet/search";
	}

	@Override
	public ToughJetRequest convertToRequest(BusyFlightsRequest request) {
		return RequestConverter.toThoughJetRequest(request);
	}

	@Override
	public Class<ToughJetResponse[]> getResponseType() {
		return ToughJetResponse[].class;
	}

	@Override
	public Function<ToughJetResponse, BusyFlightsResponse> getResponse() {
		return ResponseConverter.mapToughJetResponseToBusyFlightsResponse;
	}
}