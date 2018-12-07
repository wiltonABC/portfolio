package br.com.wilton.portfolio.resource;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.wilton.portfolio.dao.MessageDao;
import br.com.wilton.portfolio.model.Message;

@Stateless
@Path("messages")
public class MessageResource {
	
	@Inject
	private MessageDao messageDao;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			Message message = messageDao.find(id);
			
			if (message == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(message).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}

		return response;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Message message) {
		
		Response response = null;
		
		try {	
			
			messageDao.persist(message);
			
			URI uri = URI.create("/messages/" + message.getIdMessage());
			response = Response.created(uri).build();
			
			//Try to send email
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		
		return response;
	}

}
