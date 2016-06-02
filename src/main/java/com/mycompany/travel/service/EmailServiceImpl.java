package com.mycompany.travel.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named
public class EmailServiceImpl implements EmailService {
	@Override
	public void send(String addressTo, String title, String msgs) {
		Properties props = new Properties();
		props.put("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.use.tls", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("tanat3520", "Confident");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tanat3520@gmail.com", "AirBooking"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressTo));
			message.setSubject(title);
			message.setText(msgs);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
