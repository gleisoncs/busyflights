package com.busyflights.helper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import com.busyflights.model.BusyFlightsResponse;
import com.busyflights.model.CrazyAirResponse;
import com.busyflights.model.InsanairResponse;
import com.busyflights.model.ToughJetResponse;

/**
 * RequestConverterHelper converts response objects into clients objects.
 *
 * Created by gleisoncs on 01/29/2016.
 */
public class ResponseConverter {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
			.withZone(ZoneOffset.UTC);

	public static String convertToISO8601(final LocalDateTime dateTime) {
		return dateTime.format(formatter);
	}

	public static Function<CrazyAirResponse, BusyFlightsResponse> mapCrazyAirResponseToBusyFlightsResponse = new Function<CrazyAirResponse, BusyFlightsResponse>() {
		@Override
		public BusyFlightsResponse apply(CrazyAirResponse crazyAirResponse) {
			return new BusyFlightsResponse(crazyAirResponse.getAirline(), 
					"CrazyAir",
					new BigDecimal(crazyAirResponse.getPrice()), 
					crazyAirResponse.getDepartureAirportCode(),
					crazyAirResponse.getDestinationAirportCode(),
					convertToISO8601(CrazyAirResponse.getLocalDateTime(crazyAirResponse.getDepartureDate())),
					convertToISO8601(CrazyAirResponse.getLocalDateTime(crazyAirResponse.getArrivalDate())));
		}
	};

	public static Function<ToughJetResponse, BusyFlightsResponse> mapToughJetResponseToBusyFlightsResponse = new Function<ToughJetResponse, BusyFlightsResponse>() {
		@Override
		public BusyFlightsResponse apply(ToughJetResponse toughJetResponse) {
			return new BusyFlightsResponse(toughJetResponse.getCarrier(), 
					"ToughJet",
					toughJetResponse.getBasePrice().add(toughJetResponse.getTax()).subtract(toughJetResponse.getDiscount()),
					toughJetResponse.getDepartureAirportName(), 
					toughJetResponse.getArrivalAirportName(), 
					null, 
					null);
		}
	};
	
	public static Function<InsanairResponse, BusyFlightsResponse> mapInsanairResponseToBusyFlightsResponse = new Function<InsanairResponse, BusyFlightsResponse>() {
		@Override
		public BusyFlightsResponse apply(InsanairResponse insanairResponse) {
			return new BusyFlightsResponse(insanairResponse.getCarrier(), 
					"Insanair",
					insanairResponse.getBasePrice().add(insanairResponse.getTax()).subtract(insanairResponse.getDiscount()),
					insanairResponse.getDepartureAirportName(), 
					insanairResponse.getArrivalAirportName(), 
					null, 
					null);
		}
	};
}