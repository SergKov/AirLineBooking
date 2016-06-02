package com.mycompany.travel.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.travel.dao.EmployeeDao;
import com.mycompany.travel.domain.Employee;
import com.mycompany.travel.domain.StatusEmployee;
import com.mycompany.travel.exception.NoAccessException;
import com.mycompany.travel.exception.NoSuchUserException;
import com.mycompany.travel.exception.UserExistsException;

@Named
public class EmployeeServiceImpl implements EmployeeService {
	@Inject
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public Integer create(Employee employee) {
		if (!findByLogin(employee.getLogin())) {
			employee.setStatus(StatusEmployee.WORK);
			employeeDao.create(employee);
			return employee.getId();
		} else {
			throw new UserExistsException("This username is occupied.");
		}
	}

	@Override
	public Employee signIn(String login, String password) {
		try {
			Employee employee = employeeDao.findByCredentials(login, password);
			checkNotFiredEmployee(employee);
			return employee;
		} catch (NoResultException nre) {
			throw new NoSuchUserException("No user with such credentials.", nre);
		}
	}

	private void checkNotFiredEmployee(Employee employee) {
		if (employee.getStatus() == StatusEmployee.FIRED) {
			throw new NoAccessException("You don't have access");
		}
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeDao.findById(id);
	}

	@Override
	public boolean findByLogin(String login) {
		try {
			employeeDao.findByLogin(login);
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}

}
