package com.busyflights.service;

import java.util.List;

import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.BusyFlightsResponse;

/**
 * Interface representing BusyFlight Services
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
public interface BusyFlightsService {

    List<BusyFlightsResponse> search(BusyFlightsRequest request);
}
