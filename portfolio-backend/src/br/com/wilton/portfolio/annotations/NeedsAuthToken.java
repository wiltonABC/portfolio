package br.com.wilton.portfolio.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

//This annotation is binded to the request filter to control resources who will need auth token to be accessed
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface NeedsAuthToken {
	
	String[] roles() default {};

}
