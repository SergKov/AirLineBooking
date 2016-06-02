package com.mycompany.travel.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mycompany.travel.domain.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Flight> findFlightsByData(LocalDate dateDepart, String from, String to) {
		TypedQuery<Flight> query = em.createQuery(
				"SELECT fl FROM Flight fl WHERE fl.departureDateTime >= :from AND fl.departureDateTime < :to "
						+ "AND fl.leavingFrom = :placeFrom AND fl.goingTo = :placeTo "
						+ "AND fl.departureDateTime > :now",
				Flight.class);
		query.setParameter("from", Timestamp.valueOf(dateDepart.atStartOfDay()));
		query.setParameter("to", Timestamp.valueOf(dateDepart.plusDays(1).atStartOfDay()));
		query.setParameter("placeFrom", from);
		query.setParameter("placeTo", to);
		query.setParameter("now", Timestamp.valueOf(LocalDateTime.now()));
		return query.getResultList();
	}

	@Override
	public List<Flight> getTimetable(LocalDate from, LocalDate to) {
		TypedQuery<Flight> query = em.createQuery(
				"SELECT fl FROM Flight fl WHERE fl.departureDateTime >= :date AND fl.departureDateTime < :nextDate "
						+ "AND fl.departureDateTime > :now",
				Flight.class);
		query.setParameter("date", Timestamp.valueOf(from.atStartOfDay()));
		query.setParameter("nextDate", Timestamp.valueOf(to.plusDays(1).atStartOfDay()));
		query.setParameter("now", Timestamp.valueOf(LocalDateTime.now()));
		return query.getResultList();
	}

	@Override
	public void add(Flight flight) {
		em.persist(flight);
	}

	@Override
	public void update(Flight flight) {
		em.merge(flight);
	}

	@Override
	public Flight findById(Integer id) {
		return em.find(Flight.class, id);
	}

	@Override
	public void remove(Flight flight) {
		em.remove(flight);
	}

}
