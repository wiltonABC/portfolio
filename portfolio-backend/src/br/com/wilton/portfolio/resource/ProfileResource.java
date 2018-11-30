package br.com.wilton.portfolio.resource;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.wilton.portfolio.annotations.ProfileFullView;
import br.com.wilton.portfolio.dao.FeedbackDao;
import br.com.wilton.portfolio.dao.MessageDao;
import br.com.wilton.portfolio.dao.ProfileDao;
import br.com.wilton.portfolio.dao.SkillDao;
import br.com.wilton.portfolio.dao.WorkDoneDao;
import br.com.wilton.portfolio.model.Feedback;
import br.com.wilton.portfolio.model.Message;
import br.com.wilton.portfolio.model.Profile;
import br.com.wilton.portfolio.model.Skill;
import br.com.wilton.portfolio.model.WorkDone;


@Path("profiles")
@Stateless
public class ProfileResource {
	
	@Inject()
	private ProfileDao profileDao;
	
	@Inject
	private SkillDao skillDao;
	
	@Inject
	private MessageDao messageDao;
	
	@Inject
	private FeedbackDao feedbackDao;
	
	@Inject
	private WorkDoneDao workDoneDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response find(@PathParam("id") long id) {
		
		Response response = null;

		
		try {	
			Profile profile = profileDao.find(id);
			
			if (profile == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(profile).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/detailed")
	@ProfileFullView
	public Response findFull(@PathParam("id") long id) {
		
		Response response = null;
		

		try {
			Profile profile = profileDao.findEager(id);

			if (profile == null) {
				response = Response.status(404).build();
			} else {
				response = Response.ok(profile).build();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}

		return response;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Profile profile) {
		
		Response response = null;
		
		try {	
			
			profileDao.persist(profile);
			
			URI uri = URI.create("/profiles/" + profile.getIdProfile());
			response = Response.created(uri).build();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/skills")
	public Response getProfileSkills(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			List<Skill> skills = skillDao.findByProfile(id);
			
			/* When using Jackson for entity serialization and Entity Filtering together we need to wrap the Response Lists in a GenericEntity
			or a exception is thrown */
			GenericEntity<List<Skill>> entity = new GenericEntity<List<Skill>>(skills){};
			
			if (skills == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(entity).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/messages")
	public Response getProfileMessages(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			List<Message> messages = messageDao.findByProfile(id);
			
			GenericEntity<List<Message>> entity = new GenericEntity<List<Message>>(messages){};
			
			if (messages == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(entity).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/feedbacks")
	public Response getProfileFeedbacks(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			List<Feedback> feedbacks = feedbackDao.findByProfile(id);
			
			GenericEntity<List<Feedback>> entity = new GenericEntity<List<Feedback>>(feedbacks){};
			
			if (feedbacks == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(entity).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/work-done")
	public Response getProfileWorkDone(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			List<WorkDone> workDone = workDoneDao.findByProfile(id);
			
			GenericEntity<List<WorkDone>> entity = new GenericEntity<List<WorkDone>>(workDone){};
			
			if (workDone == null) {
				response = Response.status(404).build();
			} else {
				response= Response.ok(entity).build();
			}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		return response;
	}
	
}