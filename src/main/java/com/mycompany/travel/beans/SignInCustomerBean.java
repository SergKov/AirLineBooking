package com.mycompany.travel.beans;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.travel.domain.Customer;
import com.mycompany.travel.exception.NoSuchUserException;
import com.mycompany.travel.service.CustomerService;

@Named
@ViewScoped
public class SignInCustomerBean {
	private Exception exception;
	private String msgs;
	private Customer customer;
	private String login;
	private String password;

	@Inject
	private CustomerService customerService;

	public String signIn() {
		try {
			customer = customerService.signIn(login, password);
			msgs = null;
			return "BookingTickets";
		} catch (NoSuchUserException ex) {
			exception = ex;
			msgs = exception.getMessage();
			return "";
		}
	}

	public String signOut() {
		customer = null;
		return "BookingTickets?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

}
