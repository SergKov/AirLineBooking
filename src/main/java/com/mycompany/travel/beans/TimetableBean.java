package com.mycompany.travel.beans;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.service.FlightService;
import com.mycompany.travel.service.OrderService;

@Named
@Scope("session")
public class TimetableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2293392090928556347L;

	@Inject
	private FlightService flightService;

	@Inject
	private OrderService orderService;

	private Flight flight;
	private List<Flight> flights;
	private Date from;
	private Date to;

	public TimetableBean() {

	}

	public void createTimetable() {
		flights = flightService.getTimetable(from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	public String removeFlight(String id) {
		int n = Integer.valueOf(id);
		flightService.remove(n);
		return "Timetable";
	}

	public String removeAllExpired() {
		orderService.deleteAllExpiredOrders();
		return "Timetable";
	}

	public String cancel() {
		from = null;
		to = null;
		return "Period?faces-redirect=true";
	}

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
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
