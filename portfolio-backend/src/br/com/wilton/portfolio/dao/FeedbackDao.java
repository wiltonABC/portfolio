package br.com.wilton.portfolio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.wilton.portfolio.model.Feedback;

@Stateless
public class FeedbackDao extends GenericDao<Feedback> {

	@Override
	protected Class<Feedback> getClassType() {
		return Feedback.class;
	}

	public List<Feedback> findByProfile(long id) {
		TypedQuery<Feedback> query = em.createQuery("select f from feedback f inner join f.profile p "
				+ "where p.idProfile = :idProfile ", Feedback.class);
		query.setParameter("idProfile", id);
		return query.getResultList();
	}
	
}
