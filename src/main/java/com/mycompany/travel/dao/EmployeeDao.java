package com.mycompany.travel.dao;

import java.util.List;

import com.mycompany.travel.domain.Employee;

public interface EmployeeDao {
	public void create(Employee employee);

	public Employee findByCredentials(String login, String password);

	public Employee findByLogin(String login);

	public List<Employee> findAll();

	public void update(Employee employee);

	public Employee findById(Integer id);

}
