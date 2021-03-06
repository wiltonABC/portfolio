package br.com.wilton.portfolio.util;

import br.com.wilton.portfolio.model.Profile;

public class MailFormatter {
	
	public String getHtmlFormattedContactEmail(String senderName, String fromMail, String message) {
		String formattedMessage = "<h2><strong>Message sent through Portfolio App</strong></h2>"
				+ "<h3>Message</h3>"
				+ "<p>" + message + "</p>"
				+ "<h3>Sender Info</h3>"
				+ "<p>Name: " + senderName + "</p>"
				+ "<p>Email: <a href='mailto:" + fromMail + "'>" + fromMail + "</a></p>";
		return formattedMessage;
			 
	}
	
	public String getHtmlFormattedConfirmationEmail(String senderName, Profile profile) {
		String formattedMessage = "<h3>" + profile.getShortName() + "</h3>"
				+ "<h4>" + profile.getMainActivity() + "</h4>"
				+ "<p>Dear " + senderName + ", thanks for contacting me.</p>"
				+ "<p>I will reply your email as soon as possible.<p>"
				+ "<h4>Contact information</h4>"
				+ "<p>My portfolio site: <a href='http://portfolio-wilton.us-east-2.elasticbeanstalk.com/#/profiles/1'>http://portfolio-wilton.us-east-2.elasticbeanstalk.com/#/profiles/1</a></p>"
				+ "<p>My email: <a href='mailto:" + profile.getEmail() + "'>" + profile.getEmail()  + "</a></p>"
				+ "<p>*** This is an automated message. Please, don't reply. ***</p>";
		return formattedMessage;
			 
	}

}
