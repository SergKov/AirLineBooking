package com.mycompany.travel.service;

import java.util.List;

import com.mycompany.travel.domain.Customer;

public interface CustomerService {
	public Integer create(Customer customer);

	public List<Customer> findAll();

	public Customer findById(Integer id);

	public void update(Customer customer);

	public Customer signIn(String login, String password);

	public boolean findByLogin(String login);
}
