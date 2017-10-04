package com.busyflights.model;

import java.math.BigDecimal;

/**
 * This class represents a ToughJet single result.
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
public class InsanairResponse extends Response{

    private String carrier;

    private BigDecimal basePrice;
    private BigDecimal tax;
    private BigDecimal discount;

    private String departureAirportName;
    private String arrivalAirportName;

    public InsanairResponse() {
    }

    public InsanairResponse(String carrier, BigDecimal basePrice, BigDecimal tax, BigDecimal discount, String departureAirportName, String arrivalAirportName) {
        this.carrier = carrier;
        this.basePrice = basePrice;
        this.tax = tax;
        this.discount = discount;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }
}
