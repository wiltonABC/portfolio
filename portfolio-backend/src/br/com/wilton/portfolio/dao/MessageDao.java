package br.com.wilton.portfolio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.wilton.portfolio.model.Message;

@Stateless
public class MessageDao extends GenericDao<Message> {

	@Override
	protected Class<Message> getClassType() {
		
		return Message.class;
	}

	public List<Message> findByProfile(long id) {
		TypedQuery<Message> query = em.createQuery("select m from message m inner join m.profile p "
				+ "where p.idProfile = :idProfile ", Message.class);
		query.setParameter("idProfile", id);
		return query.getResultList();
	}
	
}
