package com.busyflights.helper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.busyflights.model.BusyFlightsRequest;
import com.busyflights.model.CrazyAirRequest;
import com.busyflights.model.InsanairRequest;
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

    public static CrazyAirRequest toCrazyAirRequest(final BusyFlightsRequest r) {
        return new CrazyAirRequest(
                r.getOrigin(), 
                r.getDestination(),
                convertToISO8601(r.getDepartureDate()), 
                convertToISO8601(r.getReturnDate()),
                r.getNumberOfPassengers());
    }

    public static ToughJetRequest toThoughJetRequest(final BusyFlightsRequest r) {
        return new ToughJetRequest(
                r.getOrigin(), 
                r.getDestination(),
                convertToISO8601(r.getDepartureDate()), 
                convertToISO8601(r.getReturnDate()),
                r.getNumberOfPassengers());
    }
    
    public static InsanairRequest toRyanairRequest(final BusyFlightsRequest r) {
        return new InsanairRequest(
                r.getOrigin(), 
                r.getDestination(),
                convertToISO8601(r.getDepartureDate()), 
                convertToISO8601(r.getReturnDate()),
                r.getNumberOfPassengers());
    }
}