package com.mycompany.travel.beans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Order;
import com.mycompany.travel.service.OrderService;

@Named
@Scope("session")
public class PersonalAccountBean {
	private List<Order> orders;
	@Inject
	private OrderService orderService;

	public PersonalAccountBean() {

	}

	public void findAllCustomerOrders(Integer id) {
		orders = orderService.findAllOrdersByCustomerId(id);
	}

	public void cancel(Integer id) {
		orderService.cancel(id);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
