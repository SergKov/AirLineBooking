package com.mycompany.travel.beans;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.travel.domain.Employee;
import com.mycompany.travel.domain.StatusEmployee;
import com.mycompany.travel.service.EmployeeService;

@Named
@ViewScoped
public class ListEmployeesBean {
	private List<Employee> employees;

	@Inject
	private EmployeeService employeeService;

	public static final StatusEmployee[] statuses = StatusEmployee.values();

	public void refreshList() {
		employees = employeeService.findAll();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

}
