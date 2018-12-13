package br.com.wilton.portfolio.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Class to read the configuration file with app properties 
public class AppConfig {
	
	private Properties properties;
	
	private static AppConfig instance;
	
	private AppConfig() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("br/com/wilton/portfolio/config/appconfig.properties");
		
		Properties prop = new Properties();
		prop.load(input);
		
		this.properties = prop;
	}
	
	public static AppConfig getInstance() throws IOException {
		if (instance == null) {
			return new AppConfig();
		}
		return instance;
	}
	
	public Properties getProperties() {
		return this.properties;
	}

}
