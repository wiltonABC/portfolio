package br.com.wilton.portfolio.resource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.wilton.portfolio.dao.WorkDoneDao;
import br.com.wilton.portfolio.model.WorkDone;

@Stateless
@Path("work-done")
public class WorkDoneResource {

	@Inject
	private WorkDoneDao workDoneDao;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			WorkDone workDone = workDoneDao.find(id);
			
			if (workDone == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(workDone).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}

		return response;
	}
	
}
