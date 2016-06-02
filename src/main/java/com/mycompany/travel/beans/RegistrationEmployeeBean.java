package com.mycompany.travel.beans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Employee;
import com.mycompany.travel.domain.PositionEmployee;
import com.mycompany.travel.exception.NoAccessException;
import com.mycompany.travel.exception.UserExistsException;
import com.mycompany.travel.service.EmployeeService;

@Named
@Scope("request")
public class RegistrationEmployeeBean {
	private Employee employee;
	private Exception exception;
	private String msgs;

	public static final PositionEmployee[] positions = { PositionEmployee.ADMINISTRATOR, PositionEmployee.ACCOUNTANT,
			PositionEmployee.BUSINESS_ANALITIC };

	@Inject
	private EmployeeService employeeService;

	public RegistrationEmployeeBean() {

	}

	@PostConstruct
	public void init() {
		employee = new Employee();
	}

	public String addEmployee() {
		try {
			employeeService.create(employee);
			return "ListEmployees?faces-redirect=true";
		} catch (UserExistsException ex) {
			exception = ex;
			msgs = exception.getMessage();
			return "";
		} catch (NoAccessException ex) {
			exception = ex;
			msgs = exception.getMessage();
			return "";
		}
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

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public PositionEmployee[] getPositions() {
		return positions;
	}

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

}
