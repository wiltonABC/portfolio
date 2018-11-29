package br.com.wilton.portfolio.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;

import br.com.wilton.portfolio.model.Profile;

@Stateless
public class ProfileDao extends GenericDao<Profile> {

	public Profile findEager(long id) {
		TypedQuery<Profile> query = em.createQuery("select p from profile p left join fetch p.skills s left join fetch s.skillCategory where p.idProfile = :idProfile", 
				Profile.class);
		query.setParameter("idProfile", id);
		
		Profile profile = query.getSingleResult();
		
		//Force initialization of lazy load collections
		Hibernate.initialize(profile.getFeedbacks());
		Hibernate.initialize(profile.getMessages());
		Hibernate.initialize(profile.getWorkDone());
		
		return profile;
	}
	
	@Override
	protected Class<Profile> getClassType() {
		
		return Profile.class;
	}

}
