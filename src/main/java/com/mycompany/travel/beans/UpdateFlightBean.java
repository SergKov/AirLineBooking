package com.mycompany.travel.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.exception.FlightHasPassengersException;
import com.mycompany.travel.service.FlightService;

@Named
@Scope("session")
public class UpdateFlightBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906422250245971125L;

	private Flight flight;

	@Inject
	private FlightService flightService;

	private Date from;
	private Date to;
	private Exception exception;

	public UpdateFlightBean() {

	}

	public String editFlight(Integer id) {
		flight = flightService.findById(id);
		return "updateFlight";
	}

	public String editPrice(Integer id) {
		flight = flightService.findById(id);
		return "updatePrice";
	}

	public String updateFlight() {
		try {
			flight.setDepartureDateTime(new Timestamp(from.getTime()));
			flight.setArrivalInDateTime(new Timestamp(to.getTime()));
			flight.setPassengersAvailable(flight.getMaxPassengers());
			flightService.updateFlight(flight);
			return "Timetable";
		} catch (FlightHasPassengersException ex) {
			exception = ex;
			return "";
		}

	}

	public String updatePrice() {
		flightService.updatePrice(flight);
		return "Timetable";
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

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
