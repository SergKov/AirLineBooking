package com.mycompany.travel.beans;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mycompany.travel.domain.Employee;
import com.mycompany.travel.exception.NoAccessException;
import com.mycompany.travel.exception.NoSuchUserException;
import com.mycompany.travel.service.EmployeeService;

@Named
@ViewScoped
public class AccountBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8287195593017130681L;

	private Exception exception;
	private String login;
	private String password;
	private String msgs;

	@Inject
	private EmployeeService employeeService;
	private Employee employee;

	public AccountBean() {

	}

	private static final Logger log = LogManager.getLogger();

	public void callLogging() {
		log.info("Login" + " " + employee.getLogin());
	}

	public void callException() throws Exception {
		RuntimeException ex = new RuntimeException("This is my exception");
		throw ex;
	}

	public String signIn() {
		try {
			employee = employeeService.signIn(login, password);
			msgs = null;
			callLogging();
			switch (employee.getPosition()) {
			case ADMINISTRATOR:
				return "/administrator/Period";
			case ACCOUNTANT:
				return "/accountant/ListOrders";
			case BUSINESS_ANALITIC:
				return "/businessAnalytic/Period";
			case SECURITY_OFFICER:
				return "/securityOfficer/ListEmployees";
			}
		} catch (NoSuchUserException | NoAccessException ex) {
			exception = ex;
			login = null;
			password = null;
			msgs = exception.getMessage();
		}
		return "";
	}

	public String signOut() {
		employee = null;
		return "/securityOfficer/SignInEmployee?faces-redirect=true";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
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

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

}
