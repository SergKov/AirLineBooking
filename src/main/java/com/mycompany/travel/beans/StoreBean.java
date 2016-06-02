package com.mycompany.travel.beans;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.service.FlightService;

@Named("storeBean")
@ViewScoped
public class StoreBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8885821761540870772L;

	public static final String DEFAULT_LEAVING_FROM = "Kiev";

	private List<Flight> flights;
	private Date dateDepart;
	private String from;
	private String to;

	@Inject
	private FlightService flightService;

	public StoreBean() {

	}

	@PostConstruct
	public void init() {
		from = DEFAULT_LEAVING_FROM;
	}

	public String findTickets() {
		flights = flightService.findFlightsByData(dateDepart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				from, to);
		return "ListFlights";
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
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

	public String getDefaultLeavingFrom() {
		return DEFAULT_LEAVING_FROM;
	}

}
