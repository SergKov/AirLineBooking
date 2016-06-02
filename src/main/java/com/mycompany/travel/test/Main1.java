package com.mycompany.travel.test;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.travel.service.TicketService;

public class Main1 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/application-config.xml");
		TicketService ticketService = ctx.getBean(TicketService.class);

		System.out.println("Hi!");

		System.out.println(ticketService.getReportByPlace(LocalDate.now().minusMonths(1), LocalDate.now().plusDays(3)));

	}
}
