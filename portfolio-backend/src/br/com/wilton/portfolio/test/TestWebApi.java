package br.com.wilton.portfolio.test;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import br.com.wilton.portfolio.model.Profile;

public class TestWebApi {
	
	public static void main(String[] args) {
		
		Profile profile = new Profile();
		
		profile.setAbout("I'm a software developer since 1999 and I have worked with many kinds of solutions trhough these years includind back-end, front-end, desktop and mobile applications.\n\n" + 
				"I like to experience new challenges and learn new technologies. So, I've been always adding new IT knowledge to my skill set during my career.\n\n" + 
				"My main goal is to provide modern and smart software solutions to the clients, no mather if I work as a freelancer or as an employee.");
		
		profile.setDateCreated(new Date());
		profile.setDateModified(profile.getDateCreated());
		profile.setEmail("wiltongomesjr@gmail.com");
		profile.setImage("/assets/img/wilton.jpg");
		profile.setMainActivity("Systems Analyst | BI Developer");
		profile.setName("Wilton Gomes da Costa Júnior");
		profile.setShortName("Wilton Costa");
		
		ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("http://localhost:8080/webapi");
		
		Entity<Profile> entity = Entity.entity(profile, MediaType.APPLICATION_JSON);
		
		Response response = target.path("/profiles").request().post(entity);
		
		System.out.println("Response status code: " + response.getStatus());
	}
	
}
