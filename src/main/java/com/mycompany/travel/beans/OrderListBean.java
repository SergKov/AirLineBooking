package com.mycompany.travel.beans;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.travel.domain.Order;
import com.mycompany.travel.service.OrderService;

@Named
@ViewScoped
public class OrderListBean {
	private List<Order> orders;
	@Inject
	private OrderService orderService;

	public OrderListBean() {

	}

	public void getAllBookedTickets() {
		orders = orderService.findAllBookedOrders();
	}

	public void cancel(Integer id) {
		orderService.cancel(id);
	}

	public void update(Integer id) {
		orderService.setStatusPaid(id);
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
