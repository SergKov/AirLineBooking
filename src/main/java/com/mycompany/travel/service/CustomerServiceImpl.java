package com.mycompany.travel.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.travel.dao.CustomerDao;
import com.mycompany.travel.domain.Customer;
import com.mycompany.travel.exception.NoSuchUserException;
import com.mycompany.travel.exception.UserExistsException;

@Named
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private CustomerDao customerDao;

	@Override
	@Transactional
	public Integer create(Customer customer) {
		if (!findByLogin(customer.getLogin())) {
			customerDao.create(customer);
			return customer.getId();
		} else {
			throw new UserExistsException("This username is occupied.");
		}
	}

	@Override
	public Customer signIn(String login, String password) {
		try {
			Customer customer = customerDao.findByCredentials(login, password);
			return customer;
		} catch (NoResultException nre) {
			throw new NoSuchUserException("No user with such credentials.", nre);
		}
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	@Override
	public boolean findByLogin(String login) {
		try {
			customerDao.findByLogin(login);
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}

}
