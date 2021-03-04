package com.example.Mail.sendMail;

	import java.io.File;
	import java.util.Properties;

	import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeBodyPart;
	import javax.mail.internet.MimeMessage;
	import javax.mail.internet.MimeMultipart;

	public class SendMailClass {
		public static void main(String[] args) {
			
			System.out.println("preparing to send message ...");
			String message = "Hello , Dear, this is message for testing purpose . ";
			String subject = "Testcode : Confirmation";
			String to = "iamashishbisht@gmail.com";
			String from = "iashishbisht@gmail.com";
			
			sendEmail(message,subject,to,from);
		}  
 
		
		//this is responsible to send email..
		private static void sendEmail(String message, String subject, String to, String from) {
			
			//Variable for gmail
			String host="smtp.gmail.com";
			
			//get the system properties
			Properties properties = System.getProperties();
			System.out.println("PROPERTIES "+properties);
			
			//setting important information to properties object
			
			//host set
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port","465");
			properties.put("mail.smtp.ssl.enable","true");
			properties.put("mail.smtp.auth","true");
			
			//Step 1: to get the session object..
			Session session=Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {				
					return new PasswordAuthentication("iamashishbisht@gmail.com", "Madhusudhan");
				}
				
				
				
			});
			
			session.setDebug(true);
			
			//Step 2 : compose the message [text,multi media]
			MimeMessage m = new MimeMessage(session);
			
			try {
			
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
		
			
			//adding text to message
			m.setText(message);
			
			//send 
			
			//Step 3 : send the message using Transport class
			Transport.send(m);
			
			System.out.println("Sent success...................");
			
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				
		}
	}

