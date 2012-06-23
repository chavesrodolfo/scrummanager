package br.com.scrummanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.model.Requirement;
import br.com.scrummanager.model.Sprint;

@Service
public class RequirementService {
	
	public List<Requirement> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(Requirement.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(Requirement requirement) {
		try {
			JPAGenericDAO.getInstance().merge(requirement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Requirement requirement) {
		try {
			JPAGenericDAO.getInstance().remove(requirement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Requirement> procurarPorProjeto(Project projeto) {
		String hql = "from Requirement where project.id = " + projeto.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Requirement.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Requirement> procurarPorSprint(Sprint sprint) {
		String hql = "from Requirement where sprint.id = " + sprint.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Requirement.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Requirement> findByDescription(String description) {
		String hql = "from Requirement where description = '"+ description + "'";
		try {
			return JPAGenericDAO.getInstance().findHql(Requirement.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Requirement findById(Object id) {
		try {
			return JPAGenericDAO.getInstance().find(Requirement.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
