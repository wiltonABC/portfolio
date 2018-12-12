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

import br.com.wilton.portfolio.dao.FeedbackDao;
import br.com.wilton.portfolio.model.Feedback;

@Stateless
@Path("feedbacks")
public class FeedbackResource {
	
	@Inject
	private FeedbackDao feedbackDao;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			Feedback feedback = feedbackDao.find(id);
			
			if (feedback == null) {
				response = Response.status(Response.Status.NOT_FOUND).build();
			} else {
				response= Response.ok(feedback).build();
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
	public Response insert(Feedback feedback) {
		
		Response response = null;
		
		try {	
			
			feedbackDao.persist(feedback);
			
			URI uri = URI.create("/feedbacks/" + feedback.getIdFeedback());
			response = Response.created(uri).build();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		
		return response;
	}

}
