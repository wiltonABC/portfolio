package br.com.wilton.portfolio.util;

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
	
	public String getHtmlFormattedConfirmationEmail(String senderName) {
		String formattedMessage = "<h3>Wilton Costa</h3>"
				+ "<h4>Systems Analyst | BI Developer</h4>"
				+ "<p>Dear " + senderName + ", thanks for contacting me.</p>"
				+ "<p>I'm gonna try to reply your email as soon as possible.<p>"
				+ "<h4>Contact information</h4>"
				+ "<p>My portfolio site: <a href='http://portfolio-wilton.us-east-2.elasticbeanstalk.com/#/profiles/1'>http://portfolio-wilton.us-east-2.elasticbeanstalk.com/#/profiles/1</a></p>"
				+ "<p>My email: <a href='mailto:wiltongomesjr@gmail.com'>wiltongomesjr@gmail.com</a></p>"
				+ "<p>*** This is an automated message. Please, don't reply. ***</p>";
		return formattedMessage;
			 
	}

}
