package br.com.wilton.portfolio.dao;

import javax.ejb.Stateless;

import br.com.wilton.portfolio.model.SkillCategory;

@Stateless
public class SkillCategoryDao extends GenericDao<SkillCategory> {

	@Override
	protected Class<SkillCategory> getClassType() {
		
		return SkillCategory.class;
	}

}
