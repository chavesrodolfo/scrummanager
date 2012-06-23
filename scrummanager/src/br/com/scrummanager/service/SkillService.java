package br.com.scrummanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Knowledge;
import br.com.scrummanager.model.People;
import br.com.scrummanager.model.Skill;

@Service
public class SkillService {
	
	public void save(Skill skill) {
		try {
			JPAGenericDAO.getInstance().merge(skill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Skill skill) {
		try {
			JPAGenericDAO.getInstance().remove(skill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//buscar por conhecimento e por nível e retornar pessoas
	public List<Skill> procurarPorHabilidades(Knowledge knowledge, String level) {
		String hql;
		if(level.isEmpty()){
			hql = "from Skill where knowledge.id = " + knowledge.getId();
		}else{
			hql = "from Skill where knowledge.id = " + knowledge.getId() + " and level = '" + level +"'";
		}
		try {
			return JPAGenericDAO.getInstance().findHql(Skill.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Skill> procurarPorPessoa(People people) {
		String hql = "from Skill where people.id = " + people.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Skill.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
