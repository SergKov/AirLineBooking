package com.mycompany.travel.service;

import java.util.List;

import com.mycompany.travel.domain.Employee;

public interface EmployeeService {
	public Integer create(Employee employee);

	public List<Employee> findAll();

	public Employee signIn(String login, String password);

	public boolean findByLogin(String login);

	public void update(Employee employee);

	public Employee findById(Integer id);
}
