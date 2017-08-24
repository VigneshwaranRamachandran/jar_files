package com.full;

import java.util.Properties;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {
	public static void send(String to) {

		final String user = "vignesh.chandran@adaptavantcloud.com";
		final String pass = "Vignesh95";
		String LuserPassword;
		String msg;
		String subject="NoteMaking_Password";
		msg = User.MailIduser(to);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(msg);

			
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}