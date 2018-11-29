package br.com.wilton.portfolio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.wilton.portfolio.model.WorkDone;

@Stateless
public class WorkDoneDao extends GenericDao<WorkDone> {

	@Override
	protected Class<WorkDone> getClassType() {
		return WorkDone.class;
	}

	public List<WorkDone> findByProfile(long id) {
		TypedQuery<WorkDone> query = em.createQuery("select w from work_done w inner join w.profile p "
				+ "where p.idProfile = :idProfile ", WorkDone.class);
		query.setParameter("idProfile", id);
		return query.getResultList();
	}

}
