package br.com.wilton.portfolio.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;


//Class to startup webservice resources configuration (web.xml substitute) 
@ApplicationPath("webapi")
public class PortfolioApp extends ResourceConfig {  

	public PortfolioApp() {
	
		//Registering Jackson as the Json Serializer and enabling Entity Filtering
		register(EntityFilteringFeature.class);
		register(JacksonFeature.class);
		
		/* When ResourceConfig is used instead of Application the autodiscover is disabled 
		 * so we need to register resources here
		 */
		packages("br.com.wilton.portfolio.resource");
		
	}
}
