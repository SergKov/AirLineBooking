package com.mycompany.travel.service;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.travel.dao.FlightDao;
import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.exception.FlightHasPassengersException;

@Named
public class FlightServiceImpl implements FlightService {
	@Inject
	private FlightDao flightDao;

	@Override
	@Transactional
	public void remove(Integer id) {
		Flight flight = findById(id);
		if (flight != null) {
			flightDao.remove(flight);
		}
	}

	@Override
	@Transactional
	public void updateFlight(Flight flight) {
		if (flight.getPassengersAvailable() == flight.getMaxPassengers()) {
			flightDao.update(flight);
		} else {
			throw new FlightHasPassengersException("This flight has passengers");
		}
	}

	@Override
	@Transactional
	public void add(Flight flight) {
		flightDao.add(flight);
	}

	@Override
	@Transactional
	public void updatePrice(Flight flight) {
		flightDao.update(flight);
	}

	@Override
	public Flight findById(Integer id) {
		return flightDao.findById(id);
	}

	@Override
	public List<Flight> findFlightsByData(LocalDate dateDepart, String from, String to) {
		return flightDao.findFlightsByData(dateDepart, from, to);
	}

	@Override
	public List<Flight> getTimetable(LocalDate from, LocalDate to) {
		return flightDao.getTimetable(from, to);
	}

	@Override
	public void updateAvailablePlaces(Integer id, Integer newValue) {
		Flight flight = findById(id);
		if (flight != null) {
			flight.setPassengersAvailable(newValue);
		}
	}

}
