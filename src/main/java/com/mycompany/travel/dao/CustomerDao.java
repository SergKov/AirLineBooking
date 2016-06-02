package com.mycompany.travel.dao;

import java.util.List;

import com.mycompany.travel.domain.Customer;

public interface CustomerDao {
	public void create(Customer customer);

	public List<Customer> findAll();

	public Customer findById(Integer id);

	public void update(Customer customer);

	public Customer findByCredentials(String login, String password);

	public Customer findByLogin(String login);

}
