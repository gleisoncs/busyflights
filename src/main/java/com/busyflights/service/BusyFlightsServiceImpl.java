package com.busyflights.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.busyflights.helper.RequestConverter;
import com.busyflights.helper.ResponseConverter;
import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.CrazyAirResponse;
import com.busyflights.model.ToughJetResponse;

/**
 * BusyFlightsServiceImpl is a implementation class for the BusyFlights service.
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
@Component
public class BusyFlightsServiceImpl implements BusyFlightsService {

	private static final String CRAZY_AIR_URL = "http://localhost:8080/crazyair/search";
	private static final String TOUGH_JET_URL = "http://localhost:8080/toughjet/search";

	public <T> T fetch(final String url, Object request, Class<T> responseType) {
		
		Map<String, String> vars = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();

		T result = restTemplate.postForObject(url, request, responseType, vars);

		return result;
	}

	@Override
	public List<BusyFlightsResponse> search(BusyFlightsRequest request) {

		CrazyAirResponse[] crazyAirResults = fetch(CRAZY_AIR_URL, RequestConverter.mapBusyFlightsToCrazyAirRequest, CrazyAirResponse[].class);
		ToughJetResponse[] toughJetResults = fetch(TOUGH_JET_URL, RequestConverter.mapBusyFlightsToToughJetRequest, ToughJetResponse[].class);

		List<BusyFlightsResponse> r1 = Arrays.stream(crazyAirResults).map(ResponseConverter.mapCrazyAirResponseToBusyFlightsResponse).collect(Collectors.toList());
		List<BusyFlightsResponse> r2 = Arrays.stream(toughJetResults).map(ResponseConverter.mapToughJetResponseToBusyFlightsResponse).collect(Collectors.toList());

		r1.addAll(r2);
		Collections.sort(r1);

		return r1;
	}
}