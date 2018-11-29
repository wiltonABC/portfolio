package br.com.wilton.portfolio.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.wilton.portfolio.model.Skill;

@Stateless
public class SkillDao extends GenericDao<Skill> {

	@Override
	protected Class<Skill> getClassType() {
		
		return Skill.class;
	}

	public List<Skill> findByProfile(long id) {
		TypedQuery<Skill> query = em.createQuery("select s from profile p join p.skills s join fetch s.skillCategory where p.idProfile = :idProfile", Skill.class);
		query.setParameter("idProfile", id);
		return query.getResultList();
	}

}
