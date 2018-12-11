package br.com.wilton.portfolio.util;

import java.io.IOException;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.com.wilton.portfolio.config.EmailConfig;

@Stateless
public class EmailService {
	
	private Properties mailProperties;
	private Properties configProperties;
	private String userName;
	private String password;
	private String mailTo;
	
	private Session getSession() {
		return Session.getInstance(this.mailProperties, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(userName, password);
		    }
		});
	}
	
	//It Sends the message with the given arguments 
	public void sendMail(String mailSender, String mailFrom, String mailSubject, String mailMessage) throws MessagingException, IOException {
		initializeProperties();
		
		Message message = new MimeMessage(getSession());
		message.setFrom(new InternetAddress(mailFrom));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse(this.mailTo));
		message.setSubject(mailSubject);
		 
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(mailSender + "\n\n" + mailMessage, "text/html;charset=utf-8");
		 
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		 
		message.setContent(multipart);
		 
		Transport.send(message);
	}
	
	//Initialize mail configuration properties
	private void initializeProperties() throws IOException {
		if (this.configProperties == null) {
			EmailConfig emailConfig = EmailConfig.getInstance();
			this.configProperties = emailConfig.getMailProperties();
		}
		
		if (this.mailProperties == null) {
			this.mailProperties = new Properties();
			
			this.mailProperties.put("mail.smtp.auth", this.configProperties.getProperty("mail.smtp.auth"));
			this.mailProperties.put("mail.smtp.starttls.enable", this.configProperties.getProperty("mail.smtp.starttls.enable"));
			this.mailProperties.put("mail.smtp.host", this.configProperties.getProperty("mail.smtp.host"));
			this.mailProperties.put("mail.smtp.port", this.configProperties.getProperty("mail.smtp.port"));
			this.mailProperties.put("mail.smtp.ssl.trust", this.configProperties.getProperty("mail.smtp.ssl.trust"));
			
			this.userName = this.configProperties.getProperty("mail.user.name");
			this.password = this.configProperties.getProperty("mail.user.password");
			this.mailTo = this.configProperties.getProperty("mail.mailTo");
		}
	}

}
