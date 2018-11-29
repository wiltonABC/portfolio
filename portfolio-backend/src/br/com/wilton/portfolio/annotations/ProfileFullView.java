package br.com.wilton.portfolio.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.glassfish.jersey.internal.inject.AnnotationLiteral;
import org.glassfish.jersey.message.filtering.EntityFiltering;

/* This annotation is used to define entity filtering to be use when entities 
 * need to be serialized for Json Http responses
 * 
 * If an attribute of an entity is decorated with this annotation it won`t be serialized 
 * unless the annotation is defined in the Http Response method
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EntityFiltering
public @interface ProfileFullView {
	
    public static class Factory extends AnnotationLiteral<ProfileFullView> implements ProfileFullView {

        private Factory() {
        }

        public static ProfileFullView get() {
            return new Factory();
        }
     }

}
