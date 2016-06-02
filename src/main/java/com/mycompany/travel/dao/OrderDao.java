package com.mycompany.travel.dao;

import java.sql.Timestamp;
import java.util.List;

import com.mycompany.travel.domain.Order;

public interface OrderDao {

	public Order findById(Integer id);

	public void submit(Order order);

	public List<Order> findAllBookedOrders();

	public List<Order> findAllExpiredBookings(Timestamp priorDate);

	public void remove(Order order);

	public List<Order> findAllOrdersByCustomerId(Integer id);
}
