package br.com.wilton.portfolio.resource;

import java.io.IOException;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.wilton.portfolio.config.AppConfig;
import br.com.wilton.portfolio.dao.MessageDao;
import br.com.wilton.portfolio.model.Message;
import br.com.wilton.portfolio.util.EmailService;
import br.com.wilton.portfolio.util.MailFormatter;

@Stateless
@Path("messages")
public class MessageResource {
	
	@Inject
	private MessageDao messageDao;
	
	@Inject
	private EmailService emailService;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("id") long id) {
		
		Response response = null;
		
		try {	
			Message message = messageDao.find(id);
			
			if (message == null) {
				response = Response.status(Response.Status.NOT_FOUND).build();
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
			
			//Try to send email using a new thread after the message is persisted
			(new Thread(new Runnable() {	
				@Override
				public void run() {
					try {
						MailFormatter mailFormatter = new MailFormatter();
						
						//Sending contact email
						emailService.sendMail(AppConfig.getInstance().getProperties().getProperty("mail.mailTo"),
								"Wilton Costa's Portfolio - " + message.getSubject(),
								mailFormatter.getHtmlFormattedContactEmail(message.getName(), 
								message.getEmail(), message.getMessage()));
						//Sending confirmation mail to the sender
						emailService.sendMail(message.getEmail()
								, "Wilton Costa's Portfolio - Message receiving confirmation", 
								mailFormatter.getHtmlFormattedConfirmationEmail(message.getName()));
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			})).start();
			
			
			
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.serverError().build();
		}
		
		return response;
	}

}
