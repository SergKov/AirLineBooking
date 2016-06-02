package com.mycompany.travel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mycompany.travel.domain.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Customer customer) {
		em.persist(customer);
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> cust = em.createQuery("SELECT customer FROM Customer customer", Customer.class);
		return cust.getResultList();
	}

	@Override
	public void update(Customer customer) {
		em.merge(customer);
	}

	@Override
	public Customer findById(Integer id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer findByCredentials(String login, String password) {
		TypedQuery<Customer> query = em.createQuery(
				"SELECT customer FROM Customer customer WHERE customer.login =:login AND customer.password = :password",
				Customer.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		return query.getSingleResult();
	}

	@Override
	public Customer findByLogin(String login) {
		TypedQuery<Customer> query = em
				.createQuery("SELECT customer FROM Customer customer WHERE customer.login =:login", Customer.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

}
