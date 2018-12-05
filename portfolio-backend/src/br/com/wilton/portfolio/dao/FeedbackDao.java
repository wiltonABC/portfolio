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

	public List<Feedback> findByProfile(long id, int page, int pageCount) {
		TypedQuery<Feedback> query = em.createQuery("select f from feedback f inner join f.profile p "
				+ "where p.idProfile = :idProfile order by f.dateCreated desc ", Feedback.class);
		if (page > 0 && pageCount > 0) {
			query.setFirstResult(page * pageCount - pageCount);
			query.setMaxResults(pageCount);
		}
		query.setParameter("idProfile", id);
		return query.getResultList();
	}
	
}
