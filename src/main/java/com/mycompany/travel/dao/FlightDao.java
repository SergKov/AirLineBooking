package com.mycompany.travel.dao;

import java.time.LocalDate;
import java.util.List;

import com.mycompany.travel.domain.Flight;

public interface FlightDao {

	public Flight findById(Integer id);

	public void add(Flight flight);

	public void remove(Flight flight);

	public void update(Flight flight);

	public List<Flight> findFlightsByData(LocalDate dateDepart, String from, String to);

	public List<Flight> getTimetable(LocalDate from, LocalDate to);
}
