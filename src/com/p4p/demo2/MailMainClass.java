package com.p4p.demo2;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailMainClass {
	public static void main(String [] args)
	{
		String host="smtpout.secureserver.net";  
		  final String user="testmail@gmail.com";//Keep Your mail ID 
		  final String password="password";//enter your password  
		    
		  String to="tomail@test.com";//Enter TO mail Address
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		    protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		    
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("Sajix Test MAil BY HARISH");  
		     message.setText("This is simple program of sending email using JavaMail API "+new Date()		    		 
		     		+ "<br>Thanks and Regards,"
		     		+ "<br>Harish Panakkal,");  
		       
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
	}

}
