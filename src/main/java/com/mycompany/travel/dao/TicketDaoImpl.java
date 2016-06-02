package com.mycompany.travel.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mycompany.travel.domain.StatusOrder;
import com.mycompany.travel.domain.Ticket;
import com.mycompany.travel.report.ReportDate;
import com.mycompany.travel.report.ReportPlace;

@Repository
public class TicketDaoImpl implements TicketDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ticket findById(Integer id) {
		return em.find(Ticket.class, id);
	}

	@Override
	public List<ReportDate> getReportByDate(LocalDate from, LocalDate to) {
		TypedQuery<ReportDate> query = em.createQuery(
				"SELECT new com.mycompany.travel.report.ReportDate(FUNC('YEAR', ticket.order.modifyDateTime), FUNC('MONTH', ticket.order.modifyDateTime), FUNC('DAY', ticket.order.modifyDateTime), "
						+ "COUNT(ticket), SUM(ticket.price)) " + "FROM Ticket ticket "
						+ "WHERE ticket.order.statusOrder = :sold "
						+ "AND ticket.order.modifyDateTime >= :from AND ticket.order.modifyDateTime < :to "
						+ "GROUP BY FUNC('YEAR', ticket.order.modifyDateTime), FUNC('MONTH', ticket.order.modifyDateTime), FUNC('DAY', ticket.order.modifyDateTime)",
				ReportDate.class);
		query.setParameter("sold", StatusOrder.SOLD);
		query.setParameter("from", Timestamp.valueOf(from.atStartOfDay()));
		query.setParameter("to", Timestamp.valueOf(to.plusDays(1).atStartOfDay()));
		return query.getResultList();
	}

	@Override
	public List<ReportPlace> getReportByPlace(LocalDate from, LocalDate to) {
		TypedQuery<ReportPlace> query = em.createQuery(
				"SELECT new com.mycompany.travel.report.ReportPlace(ticket.flight.leavingFrom, ticket.flight.goingTo, "
						+ "COUNT(ticket), SUM(ticket.price)) FROM Ticket ticket "
						+ "WHERE ticket.order.statusOrder = :sold "
						+ "AND ticket.order.modifyDateTime >= :from AND ticket.order.modifyDateTime < :to "
						+ "GROUP BY ticket.flight.leavingFrom, ticket.flight.goingTo",
				ReportPlace.class);
		query.setParameter("sold", StatusOrder.SOLD);
		query.setParameter("from", Timestamp.valueOf(from.atStartOfDay()));
		query.setParameter("to", Timestamp.valueOf(to.plusDays(1).atStartOfDay()));
		return query.getResultList();
	}

}
