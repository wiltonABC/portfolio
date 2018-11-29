package br.com.wilton.portfolio.test;

import java.util.Date;

import br.com.wilton.portfolio.model.SkillCategory;

public class TestJPAStartup {
	
	public static void main(String[] args) {
		
		//Hibernate Startup test
/*		EntityManagerFactory emf = Persistence.createEntityManagerFactory("portfolioBackend"); 
		
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();*/
		
		SkillCategory skillCategory = new SkillCategory();
		skillCategory.setDateCreated(new Date());
		skillCategory.setImage("img");
		skillCategory.setName("Agile");

	//	SkillCategoryDao dao = new SkillCategoryDao();
	//	dao.persist(skillCategory);
		
		System.out.println(skillCategory.getIdSkillCategory());
		
//		dao.close();
		
	//	SkillCategoryDao dao2 = new SkillCategoryDao();
		
	//	dao2.find(1);
		
//		dao2.close();
		
/*		EntityManagerFactory emf = Persistence.createEntityManagerFactory("portfolioBackend");
		EntityManager em = emf.createEntityManager(); 
		SkillCategory skillCategory = em.find(SkillCategory.class, 1L);
		em.getTransaction().begin();
		skillCategory.setImage("BI");
		em.getTransaction().commit();*/
		
//		dao.close();
	}

}
