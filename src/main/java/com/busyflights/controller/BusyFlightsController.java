package com.busyflights.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.CrazyAirRequest;
import com.busyflights.model.CrazyAirResponse;
import com.busyflights.model.ToughJetRequest;
import com.busyflights.model.ToughJetResponse;
import com.busyflights.service.BusyFlightsService;

/**
 * The BusyFlightController provides search requests.
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
@RestController
public class BusyFlightsController {

	@Autowired
	private BusyFlightsService service;

	@RequestMapping("/")
	public String welcomeScreen() {
		return "Welcome to BusyFlights Service";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<BusyFlightsResponse> search(@RequestBody BusyFlightsRequest request) {
		return service.search(request);
	}

	@RequestMapping(value = "/crazyair/search", method = RequestMethod.POST)
	public List<CrazyAirResponse> searchCrazyAir(@RequestBody CrazyAirRequest request) {
		List<CrazyAirResponse> list = new ArrayList<>();
		list.add(new CrazyAirResponse("latam", "34.45", "E", "LHR", "TMS", "01-29-2017 13:45:00", "02-15-2016 08:45:00"));
		list.add(new CrazyAirResponse("ryanair", "25.98", "E", "LHR", "TMS", "01-29-2017 15:14:00", "02-15-2016 09:35:00"));
		return list;
	}

	@RequestMapping(value = "/toughjet/search", method = RequestMethod.POST)
	public List<ToughJetResponse> searchToughJet(@RequestBody ToughJetRequest request) {
		List<ToughJetResponse> list = new ArrayList<>();
		list.add(new ToughJetResponse("easyjet", BigDecimal.valueOf(19.99), BigDecimal.valueOf(20), BigDecimal.ONE, "LHR", "TMS"));
		return list;
	}
}