package br.com.wilton.portfolio.test;

import java.io.IOException;
import java.util.Properties;

import br.com.wilton.portfolio.config.AppConfig;

public class TestBundle {
	
	public static void main(String[] args) throws IOException {
		AppConfig config = AppConfig.getInstance();
		
		Properties prop = config.getProperties();
		System.out.println(prop.getProperty("mail.mailTo"));
	}

}
