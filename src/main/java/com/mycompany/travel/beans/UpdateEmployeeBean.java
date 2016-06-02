package com.mycompany.travel.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.mycompany.travel.domain.Employee;
import com.mycompany.travel.domain.PositionEmployee;
import com.mycompany.travel.domain.StatusEmployee;
import com.mycompany.travel.service.EmployeeService;

@Named
@Scope("session")
public class UpdateEmployeeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5485772600673421917L;

	private Employee employee;

	public static final StatusEmployee[] statuses = StatusEmployee.values();
	public static final PositionEmployee[] positions = { PositionEmployee.ADMINISTRATOR, PositionEmployee.ACCOUNTANT,
			PositionEmployee.BUSINESS_ANALITIC };

	@Inject
	private EmployeeService employeeService;

	public UpdateEmployeeBean() {

	}

	@PostConstruct
	public void init() {
		employee = new Employee();
	}

	public String edit(Integer id) {
		employee = employeeService.findById(id);
		return "UpdateEmployee";
	}

	public String update() {
		employeeService.update(employee);
		return "ListEmployees";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public StatusEmployee[] getStatuses() {
		return statuses;
	}

	public PositionEmployee[] getPositions() {
		return positions;
	}

}
