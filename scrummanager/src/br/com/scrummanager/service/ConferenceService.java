package br.com.scrummanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Conference;
import br.com.scrummanager.model.Project;

@Service
public class ConferenceService {
	
	public void gravar(Conference conference) {
		try {
			JPAGenericDAO.getInstance().merge(conference);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Conference conference) {
		try {
			JPAGenericDAO.getInstance().remove(conference);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Conference> procurarPorProjeto(Project projeto) {
		String hql = "from Conference where project.id = " + projeto.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Conference.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
