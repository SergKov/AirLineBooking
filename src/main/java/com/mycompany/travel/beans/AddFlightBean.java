package com.mycompany.travel.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.service.FlightService;

@Named
@Scope("request")
public class AddFlightBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -607094877199638888L;

	private Flight flight;

	@Inject
	private FlightService flightService;

	private Date from;
	private Date to;

	public AddFlightBean() {

	}

	@PostConstruct
	public void init() {
		flight = new Flight();
		flight.setPrice(0d);
	}

	public String addFlight() {
		flight.setPassengersAvailable(flight.getMaxPassengers());
		flight.setDepartureDateTime(new Timestamp(from.getTime()));
		flight.setArrivalInDateTime(new Timestamp(to.getTime()));
		flightService.add(flight);
		return "Timetable?faces-redirect=true";
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
}
