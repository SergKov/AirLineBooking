package com.mycompany.travel.service;

import java.time.LocalDate;
import java.util.List;

import com.mycompany.travel.domain.Flight;

public interface FlightService {
	public Flight findById(Integer id);

	public void add(Flight flight);

	public void remove(Integer id);

	public void updateFlight(Flight flight);

	public void updatePrice(Flight flight);

	public void updateAvailablePlaces(Integer id, Integer newValue);

	public List<Flight> findFlightsByData(LocalDate dateDepart, String from, String to);

	public List<Flight> getTimetable(LocalDate from, LocalDate to);
}
