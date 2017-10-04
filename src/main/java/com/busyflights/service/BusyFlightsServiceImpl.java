package com.busyflights.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.busyflights.helper.ServiceCallable;
import com.busyflights.helper.RequestConverter;
import com.busyflights.helper.ResponseConverter;
import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.CrazyAirRequest;
import com.busyflights.model.CrazyAirResponse;
import com.busyflights.model.Response;
import com.busyflights.model.ToughJetRequest;
import com.busyflights.model.ToughJetResponse;
import com.busyflights.wrapper.CrazyWrapper;
import com.busyflights.wrapper.InsanairWrapper;
import com.busyflights.wrapper.ThoughWrapper;
import com.busyflights.wrapper.Wrapper;

/**
 * BusyFlightsServiceImpl is a implementation class for the BusyFlights service.
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
@Component
public class BusyFlightsServiceImpl implements BusyFlightsService {

	@Override
	public List<BusyFlightsResponse> search(BusyFlightsRequest request) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ArrayList<Wrapper> arrayOfObjects = new ArrayList<Wrapper>();

		arrayOfObjects.add(new CrazyWrapper());
		arrayOfObjects.add(new ThoughWrapper());
		arrayOfObjects.add(new InsanairWrapper());

		List<BusyFlightsResponse> finalResult = new ArrayList<BusyFlightsResponse>();
		for (Wrapper a : arrayOfObjects) {

			executor.submit(() -> {
				Callable result = new ServiceCallable<>(a.getUrl(), a.convertToRequest(request), a.getResponseType());
				try {
					finalResult.addAll((List<BusyFlightsResponse>) Arrays.stream((Response[]) result.call())
							.map(a.getResponse()).collect(Collectors.toList()));
				} catch (Exception e) {
				}
			});
		}
		
		executor.shutdown();
		while (!executor.isTerminated()) {}

		finalResult.sort((BusyFlightsResponse a, BusyFlightsResponse b) -> a.getAirline().compareTo(b.getAirline()));

		return finalResult;
	}
}