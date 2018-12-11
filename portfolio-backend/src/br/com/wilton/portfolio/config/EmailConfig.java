package br.com.wilton.portfolio.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Class to read the configuration file with email properties 
public class EmailConfig {
	
	private Properties mailProperties;
	
	private static EmailConfig instance;
	
	private EmailConfig() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("br/com/wilton/portfolio/config/emailconfig.properties");
		
		Properties prop = new Properties();
		prop.load(input);
		
		this.mailProperties = prop;
	}
	
	public static EmailConfig getInstance() throws IOException {
		if (instance == null) {
			return new EmailConfig();
		}
		return instance;
	}
	
	public Properties getMailProperties() {
		return this.mailProperties;
	}

}
