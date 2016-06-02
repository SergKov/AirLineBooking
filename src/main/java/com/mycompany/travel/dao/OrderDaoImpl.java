package com.mycompany.travel.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.travel.domain.Order;
import com.mycompany.travel.domain.StatusOrder;

@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Order> findAllBookedOrders() {
		TypedQuery<Order> query = em.createQuery("SELECT ord FROM Order ord WHERE ord.statusOrder = :booked",
				Order.class);
		query.setParameter("booked", StatusOrder.BOOKED);
		return query.getResultList();
	}

	@Override
	public List<Order> findAllExpiredBookings(Timestamp priorDateTime) {
		TypedQuery<Order> query = em.createQuery(
				"SELECT ord FROM Order ord WHERE ord.statusOrder = :booked  AND ord.modifyDateTime < :priorDateTime",
				Order.class);
		query.setParameter("booked", StatusOrder.BOOKED);
		query.setParameter("priorDateTime", priorDateTime);
		return query.getResultList();
	}

	@Override
	public Order findById(Integer id) {
		return em.find(Order.class, id);
	}

	@Override
	public void submit(Order order) {
		em.persist(order);
	}

	@Override
	@Transactional
	public void remove(Order order) {
		em.remove(order);
	}

	@Override
	public List<Order> findAllOrdersByCustomerId(Integer id) {
		TypedQuery<Order> query = em.createQuery("SELECT ord FROM Order ord WHERE ord.customer.id = :id", Order.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
