package com.mycompany.travel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/application-config.xml");
		// TicketService ticketService = ctx.getBean(TicketService.class);

		// System.out.println("===============findById(3)=====================");
		// System.out.println(ticketService.findById(3));

		// System.out.println("===============remove(3)========================");
		// ticketService.remove(3);

		// System.out.println("==============findAll========================");
		// System.out.println(ticketService.findAll());

		// System.out.println(ticketService.getReportByDate(LocalDate.now().minusDays(2),
		// LocalDate.now()));

		// System.out.println(ticketService.getReportByPlace(LocalDate.of(2015,
		// 10, 24), LocalDate.of(2015, 10, 31)));

		System.out.println(ctx.containsBean("customerBean"));

	}
}
