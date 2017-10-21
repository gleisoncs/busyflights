package com.busyflights.model;

import java.time.LocalDateTime;

/**
 * This class represents a ToughJet request.
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
public class ToughJetRequest extends Request{

    private String from;
    private String to;

    private int departureDay;
    private int departureMonth;
    private int departureYear;

    private int returnDay;
    private int returnMonth;
    private int returnYear;

    private int numberOfAdults;

    public ToughJetRequest() {
    }

    public ToughJetRequest(String from, String to, LocalDateTime departureDate, LocalDateTime returnDate, int numberOfAdults) {

        this.from = from;
        this.to = to;

        this.departureDay = departureDate.getDayOfMonth();
        this.departureMonth = departureDate.getMonthValue();
        this.departureYear = departureDate.getYear();
        this.returnDay = returnDate.getDayOfMonth();
        this.returnMonth = returnDate.getMonthValue();
        this.returnYear = returnDate.getYear();

        this.numberOfAdults = numberOfAdults;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(int departureDay) {
        this.departureDay = departureDay;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(int departureMonth) {
        this.departureMonth = departureMonth;
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(int departureYear) {
        this.departureYear = departureYear;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(int returnMonth) {
        this.returnMonth = returnMonth;
    }

    public int getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(int returnYear) {
        this.returnYear = returnYear;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
