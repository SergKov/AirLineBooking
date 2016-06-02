package com.mycompany.travel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mycompany.travel.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Employee employee) {
		em.persist(employee);
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createQuery("SELECT employee FROM Employee employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findByCredentials(String login, String password) {
		TypedQuery<Employee> query = em.createQuery(
				"SELECT employee FROM Employee employee WHERE employee.login =:login AND employee.password = :password",
				Employee.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		return query.getSingleResult();
	}

	@Override
	public Employee findByLogin(String login) {
		TypedQuery<Employee> query = em
				.createQuery("SELECT employee FROM Employee employee WHERE employee.login =:login", Employee.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public void update(Employee employee) {
		em.merge(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return em.find(Employee.class, id);
	}

}
