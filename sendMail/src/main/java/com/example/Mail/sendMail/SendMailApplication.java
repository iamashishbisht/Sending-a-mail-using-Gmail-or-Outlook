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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendMailApplication.class, args);
		
			
			System.out.println("Outlook Test");
			String message = "Hello Testing....... ";
			String subject = "Testcode : Confirmation";
			String to = "iamashishbisht@gmail.com";
			String from = "iamashishbisht@outlook.com";
			
			sendEmail(message,subject,to,from);
		}  
 
		
		//this is responsible to send email..
		private static void sendEmail(String message, String subject, String to, String from) {
			
			//String host="smtp.gmail.com";
			//String host = "outlook.office365.com";
			
			Properties properties = System.getProperties();
			System.out.println("PROPERTIES "+properties);
			
			/*
			 * properties.put("mail.smtp.host", host);
			 * properties.put("mail.smtp.port","465");
			 * properties.put("mail.smtp.ssl.enable","true");
			 * properties.put("mail.smtp.auth","true");
			 */
			
			
			  properties.put("mail.smtp.auth", "true");
			  properties.put("mail.smtp.starttls.enable", "true");
			  properties.put("mail.smtp.host", "outlook.office365.com");
			  //properties.put("mail.smtp.ssl.enable", "false");
			  properties.put("mail.smtp.port", "587");
			  
				/*
				 * properties.put("mail.transport.protocol", "smtp");
				 * properties.put("mail.smtp.socketFactory.class",
				 * "javax.net.ssl.SSLSocketFactory");
				 */
			 
			  
			  System.out.println("stting prop");
			
			//properties.put("mail.smtp.socketFactory.fallback", "true");
			/*
			 * properties.put("mail.smtp.ssl.enable", "false");
			 * properties.put("mail.smtp.host","outlook.office365.com");
			 * properties.put("mail.smtp.store.protocol","pop3s");
			 * properties.put("mail.smtp.pop3s.port","587");
			 * 
			 * properties.put("mail.smtp.pop3s.auth", "true");
			 */
			 
			
			/*props.put("mail.host", "outlook.office365.com");
	        props.put("mail.store.protocol", "pop3s");
	        props.put("mail.pop3s.auth", "true");
	        props.put("mail.pop3s.port", "995");*/
			
			Session session=Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {		
					System.out.println("auth");
					return new PasswordAuthentication("iamashishbisht@outlook.com", "Madhusudhan");
				}
				
				
				
			});
			
			session.setDebug(true);
			
			System.out.println("mim");
			
			MimeMessage mime_message = new MimeMessage(session);
			System.out.println("try");
			
			try {
			
			mime_message.setFrom(from);
			
			mime_message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			mime_message.setSubject(subject);
		
			mime_message.setText(message);
			
			Transport.send(mime_message);
			
			System.out.println("done");
			

			
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				
		}
}
