package com.mycompany.travel.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.travel.dao.OrderDao;
import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.domain.Order;
import com.mycompany.travel.domain.StatusOrder;
import com.mycompany.travel.domain.Ticket;
import com.mycompany.travel.exception.NoFreePlacesException;

@Named
public class OrderServiceImpl implements OrderService {
	@Inject
	private OrderDao orderDao;

	@Inject
	private FlightService flightService;

	@Override
	@Transactional
	public void submit(Order order) {
		order.setModifyDateTime(Timestamp.valueOf(LocalDateTime.now()));
		order.setStatusOrder(StatusOrder.BOOKED);
		orderDao.submit(order);
		decrementPassengsAvailable(order);
	}

	private void checkPlaces(Map<Flight, Integer> map) {
		for (Map.Entry<Flight, Integer> entry : map.entrySet()) {
			if (entry.getValue() < 0) {
				throw new NoFreePlacesException(
						entry.getKey().getFlightNumber() + "   " + entry.getKey().getLeavingFrom() + " -> "
								+ entry.getKey().getGoingTo() + " doesn't have free places ");
			}
		}
	}

	private void decrementPassengsAvailable(Order order) {
		Map<Flight, Integer> map = sortTicketsOfOrder(order);
		checkPlaces(map);
		map.entrySet().forEach(entry -> {
			flightService.updateAvailablePlaces(entry.getKey().getId(), entry.getValue());
		});
	}

	private Map<Flight, Integer> sortTicketsOfOrder(Order order) {
		Map<Flight, Integer> map = new HashMap<>();
		Collection<Ticket> tickets = order.getTickets();
		for (Ticket ticket : tickets) {
			Flight flight = ticket.getFlight();
			countPassengsAvailable(map, flight);
		}
		return map;
	}

	private void countPassengsAvailable(Map<Flight, Integer> map, Flight flight) {
		if (map.containsKey(flight)) {
			map.put(flight, map.get(flight) - 1);
		} else {
			map.put(flight, flight.getPassengersAvailable() - 1);
		}
	}

	@Override
	public List<Order> findAllBookedOrders() {
		return orderDao.findAllBookedOrders();
	}

	@Override
	@Transactional
	public void setStatusPaid(Integer id) {
		Order order = findById(id);
		if (order.getStatusOrder() == StatusOrder.BOOKED) {
			order.setStatusOrder(StatusOrder.SOLD);
			updateModifyDateTime(order);
		}
	}

	@Override
	@Transactional
	public void deleteAllExpiredOrders() {
		List<Order> orders = findAllExpiredBookings();
		orders.forEach(order -> cancel(order.getId()));
	}

	@Override
	public List<Order> findAllExpiredBookings() {
		return orderDao.findAllExpiredBookings(Timestamp.valueOf(LocalDateTime.now().minusDays(3)));
	}

	@Override
	@Transactional
	public void cancel(Integer id) {
		Order order = findById(id);
		order.setStatusOrder(StatusOrder.CANCELED);
		remove(id);
		incrementPassengsAvailable(order);
	}

	private void incrementPassengsAvailable(Order order) {
		Map<Flight, Integer> map = sortTicketsOfOrderAfterDelete(order);
		checkPlaces(map);
		map.entrySet().forEach(entry -> {
			flightService.updateAvailablePlaces(entry.getKey().getId(), entry.getValue());
		});
	}

	private Map<Flight, Integer> sortTicketsOfOrderAfterDelete(Order order) {
		Map<Flight, Integer> map = new HashMap<>();
		Collection<Ticket> tickets = order.getTickets();
		for (Ticket ticket : tickets) {
			Flight flight = ticket.getFlight();
			updateAvailablePassengersAfterDeleteOrder(map, flight);
		}
		return map;
	}

	private void updateAvailablePassengersAfterDeleteOrder(Map<Flight, Integer> map, Flight flight) {
		if (map.containsKey(flight)) {
			map.put(flight, map.get(flight) + 1);
		} else {
			map.put(flight, flight.getPassengersAvailable() + 1);
		}
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		Order order = findById(id);
		if (order != null) {
			orderDao.remove(order);
		}
	}

	private void updateModifyDateTime(Order order) {
		order.setModifyDateTime(Timestamp.valueOf(LocalDateTime.now()));
	}

	@Override
	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

	@Override
	public List<Order> findAllOrdersByCustomerId(Integer id) {
		return orderDao.findAllOrdersByCustomerId(id);
	}

}
