package br.com.wilton.portfolio.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Key;

import javax.annotation.Priority;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.wilton.portfolio.annotations.NeedsAuthToken;
import io.jsonwebtoken.Jwts;

//Apply this filter to annotated resource methods that need authentication
@Provider
@NeedsAuthToken
@Priority(Priorities.AUTHENTICATION)
public class NeedsAuthTokenRequestFilter implements ContainerRequestFilter {
	
	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		//Get authorized roles from the resource annotation (This will be used in the future)
		//for now it won't be used
		Method method = resourceInfo.getResourceMethod();
		
		String[] roles = {};
		
		if (method != null) {
			NeedsAuthToken needsAuthToken = method.getAnnotation(NeedsAuthToken.class);
			roles = needsAuthToken.roles();
		}
		
		
		try {
			//Get the Authorization header
			String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			
			//This API uses JWT token for authorization
			//Try to extract token from the header
			String token = authHeader.substring("Bearer".length());
			
			//For now any user that has a valid token should access the annotated methods
			//In the future a per role authorization may be implemented
			String keyString = "a@s#4dZX";
			Key key = new SecretKeySpec(keyString.getBytes(), "DES");
			
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			
		} catch (Exception e) {
			//If the token can't be validated abort request returning a forbidden status code in the response
			requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
		}
		
	}

}
