package com.mycompany.travel.beans;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Order;
import com.mycompany.travel.domain.Ticket;
import com.mycompany.travel.exception.NoFreePlacesException;
import com.mycompany.travel.service.EmailService;
import com.mycompany.travel.service.OrderService;

@Named
@Scope("session")
public class CartBean {
	private Collection<Ticket> cart;
	private String telephone;
	private String email;
	private Order lastOrder;
	private Exception exception;

	@Inject
	private SignInCustomerBean signInCustomerBean;

	@Inject
	private OrderService orderService;

	@Inject
	private EmailService emailService;

	public CartBean() {

	}

	@PostConstruct
	public void init() {
		cart = new HashSet<>();
	}

	public String addToCart(Ticket ticket) {
		cart.add(ticket);
		return "ListFlights";
	}

	public void removeFromCart(Ticket ticket) {
		cart.remove(ticket);
	}

	public String submitOrder() {
		Order order = new Order();
		try {
			submitOrder(order);
			lastOrder = order;
			emailService.send(email, " Your Order",
					"Hello Dear Customer!" + "\n\n Your order's number ->" + order.getId() + "\n\n Count of tickets -> "
							+ countLastOrderItems() + "\n\n Sum of tickets ->" + countLastOrderSum() + " $");
			return "YourOrder";
		} catch (NoFreePlacesException ex) {
			exception = ex;
			return ex.getMessage();
		}
	}

	private void submitOrder(Order order) {
		cart.forEach(ticket -> ticket.setOrder(order));
		order.setTickets(cart);
		if (isCustomerAuthorised()) {
			order.setCustomer(signInCustomerBean.getCustomer());
		}
		order.setEmail(email);
		order.setTelephone(telephone);
		orderService.submit(order);
		cart = new HashSet<>();
	}

	public boolean isCustomerAuthorised() {
		System.out.println(signInCustomerBean != null);
		return signInCustomerBean != null && signInCustomerBean.getCustomer() != null;
	}

	public String createOrder() {
		if (isCustomerAuthorised()) {
			telephone = signInCustomerBean.getCustomer().getTelephoneOne();
			email = signInCustomerBean.getCustomer().getEmail();
			return submitOrder();
		}
		return "PrepareOrder?faces-redirect=true";
	}

	public int countCartItems() {
		return cart.size();
	}

	public double countCartSum() {
		return cart.stream().mapToDouble(ticket -> ticket.getPrice()).sum();
	}

	public int countLastOrderItems() {
		return lastOrder.getTickets().size();
	}

	public double countLastOrderSum() {
		return lastOrder.getTickets().stream().mapToDouble(ticket -> ticket.getPrice()).sum();
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Collection<Ticket> getCart() {
		return cart;
	}

	public void setCart(Collection<Ticket> cart) {
		this.cart = cart;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Order getLastOrder() {
		return lastOrder;
	}

	public void setLastOrder(Order lastOrder) {
		this.lastOrder = lastOrder;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public SignInCustomerBean getSignInCustomerBean() {
		return signInCustomerBean;
	}

	public void setSignInCustomerBean(SignInCustomerBean signInCustomerBean) {
		this.signInCustomerBean = signInCustomerBean;
	}

}
