package br.com.wilton.portfolio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//GenericDao class define a PersistenceContext and provides some basic jpa operations to descendent classes
public abstract class GenericDao<T> {
	
	@PersistenceContext(unitName="portfolioBackend_JTA")
	protected EntityManager em;
	
	public T find(long id) {
		return em.find(getClassType(), id);
	}
	
	public void persist(T entity) {
		em.persist(entity);
	}
	
	public void merge(T entity) {
		em.merge(entity);
	}
	
	public void remove(T entity) {
		em.remove(entity);
	}
	
	//Class type is provided by the child class
	protected abstract Class<T> getClassType();

}
