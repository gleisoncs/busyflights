package com.busyflights.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.CrazyAirRequest;
import com.busyflights.model.CrazyAirResponse;
import com.busyflights.model.InsanairRequest;
import com.busyflights.model.InsanairResponse;
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
	public ResponseEntity<List<BusyFlightsResponse>> search(@RequestBody BusyFlightsRequest request) {
		return new ResponseEntity<List<BusyFlightsResponse>>(service.search(request), HttpStatus.OK);
	}

	@RequestMapping(value = "/crazyair/search", method = RequestMethod.POST)
	public ResponseEntity<List<CrazyAirResponse>> searchCrazyAir(@RequestBody CrazyAirRequest request) throws InterruptedException {
		List<CrazyAirResponse> list = new ArrayList<>();
		list.add(new CrazyAirResponse("crazyair", "34.45", "E", "LHR", "TMS", "01-29-2017 13:45:00", "02-15-2016 08:45:00"));
		list.add(new CrazyAirResponse("crazyair", "25.98", "E", "LHR", "TMS", "01-29-2017 15:14:00", "02-15-2016 09:35:00"));
		return new ResponseEntity<List<CrazyAirResponse>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/toughjet/search", method = RequestMethod.POST)
	public ResponseEntity<List<ToughJetResponse>> searchToughJet(@RequestBody ToughJetRequest request) throws Exception {
		List<ToughJetResponse> list = new ArrayList<>();
		list.add(new ToughJetResponse("toughjet", BigDecimal.valueOf(19.99), BigDecimal.valueOf(20), BigDecimal.ONE, "LHR", "TMS"));
		return new ResponseEntity<List<ToughJetResponse>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insanair/search", method = RequestMethod.POST)
	public ResponseEntity<List<InsanairResponse>> searchRyanair(@RequestBody InsanairRequest request) throws Exception {
		List<InsanairResponse> list = new ArrayList<>();
		list.add(new InsanairResponse("insanair", BigDecimal.valueOf(19.99), BigDecimal.valueOf(20), BigDecimal.ONE, "LHR", "TMS"));
		return new ResponseEntity<List<InsanairResponse>>(list, HttpStatus.OK);
	}
}