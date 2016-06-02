package com.mycompany.travel.service;

import java.util.List;

import com.mycompany.travel.domain.Order;

public interface OrderService {

	public Order findById(Integer id);

	public void submit(Order order);

	public void setStatusPaid(Integer id);

	public List<Order> findAllBookedOrders();

	public List<Order> findAllExpiredBookings();

	public void deleteAllExpiredOrders();

	public void cancel(Integer id);

	public void remove(Integer id);

	public List<Order> findAllOrdersByCustomerId(Integer id);
}
