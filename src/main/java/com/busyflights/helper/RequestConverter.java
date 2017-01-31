package com.busyflights.helper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.CrazyAirRequest;
import com.busyflights.model.ToughJetRequest;

/**
 * RequestConverterHelper converts clients objects into request objects.
 *
 * Created by gleisoncs on 01/29/2016.
 */
public class RequestConverter {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
			.withZone(ZoneOffset.UTC);

	public static LocalDateTime convertToISO8601(final String iso) {
		return LocalDateTime.parse(iso, formatter);
	}

	public static Function<BusyFlightsRequest, CrazyAirRequest> mapBusyFlightsToCrazyAirRequest = new Function<BusyFlightsRequest, CrazyAirRequest>() {
		@Override
		public CrazyAirRequest apply(BusyFlightsRequest request) {
			return new CrazyAirRequest(request.getOrigin(), 
					request.getDestination(),
					convertToISO8601(request.getDepartureDate()), 
					convertToISO8601(request.getReturnDate()),
					request.getNumberOfPassengers());
		}
	};

	public static Function<BusyFlightsRequest, ToughJetRequest> mapBusyFlightsToToughJetRequest = new Function<BusyFlightsRequest, ToughJetRequest>() {
		@Override
		public ToughJetRequest apply(BusyFlightsRequest request) {
			return new ToughJetRequest(request.getOrigin(), 
					request.getDestination(),
					convertToISO8601(request.getDepartureDate()), 
					convertToISO8601(request.getReturnDate()),
					request.getNumberOfPassengers());
		}
	};
}