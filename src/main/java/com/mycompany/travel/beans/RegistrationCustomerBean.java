package com.mycompany.travel.beans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Customer;
import com.mycompany.travel.exception.UserExistsException;
import com.mycompany.travel.service.CustomerService;
import com.mycompany.travel.service.EmailService;

@Named
@Scope("request")
public class RegistrationCustomerBean {
	private Customer customer;
	private Exception exception;
	private String msgs;
	@Inject
	private CustomerService customerService;
	@Inject
	private EmailService emailService;

	public RegistrationCustomerBean() {

	}

	@PostConstruct
	public void init() {
		customer = new Customer();
	}

	public String createCustomer() {
		try {
			customerService.create(customer);
			emailService.send(customer.getEmail(), "New Customer", "Hello Dear Customer! \n\n Your login is "
					+ customer.getLogin() + "\n\n Your password is " + customer.getPassword());
			return "BookingTickets";
		} catch (UserExistsException ex) {
			exception = ex;
			msgs = exception.getMessage();
			return "";
		}
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

}
