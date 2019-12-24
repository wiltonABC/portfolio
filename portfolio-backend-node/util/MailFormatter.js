class MailFormatter {

    static getHtmlFormattedContactEmail (senderName, fromMail, message) {
		var formattedMessage = "<h2><strong>Message sent through Portfolio App</strong></h2>"
				+ "<h3>Message</h3>"
				+ "<p>" + message + "</p>"
				+ "<h3>Sender Info</h3>"
				+ "<p>Name: " + senderName + "</p>"
				+ "<p>Email: <a href='mailto:" + fromMail + "'>" + fromMail + "</a></p>";
		return formattedMessage;
			 
    };
    
	static getHtmlFormattedConfirmationEmail (senderName, profile, url) {
		var formattedMessage = "<h3>" + profile.shortName + "</h3>"
				+ "<h4>" + profile.mainActivity + "</h4>"
				+ "<p>Dear " + senderName + ", thanks for contacting me.</p>"
				+ "<p>I will reply your email as soon as possible.<p>"
				+ "<h4>Contact information</h4>"
				+ "<p>My portfolio site: <a href='" + url+ "'>" + url + "</a></p>"
				+ "<p>My email: <a href='mailto:" + profile.email + "'>" + profile.email  + "</a></p>"
				+ "<p>*** This is an automated message. Please, don't reply. ***</p>";
        return formattedMessage;    
    
    };   

}

module.exports = MailFormatter;