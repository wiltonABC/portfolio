package br.com.wilton.portfolio.test;

import java.io.IOException;
import java.util.Properties;

import br.com.wilton.portfolio.config.EmailConfig;

public class TestBundle {
	
	public static void main(String[] args) throws IOException {
		EmailConfig config = EmailConfig.getInstance();
		
		Properties prop = config.getMailProperties();
		System.out.println(prop.getProperty("mail.mailTo"));
	}

}
