package br.com.scrummanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.model.Sprint;

@Service
public class SprintService{

	public List<Sprint> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(Sprint.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(Sprint Sprint) {
		try {
			JPAGenericDAO.getInstance().merge(Sprint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Sprint sprint) {
		try {
			JPAGenericDAO.getInstance().remove(sprint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sprint procurarPor(Sprint sprint) {
		try {
			return JPAGenericDAO.getInstance().find(Sprint.class,
					sprint.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sprint;
	}

	public List<Sprint> procurarPorProjeto(Project projeto) {
		String hql = "from Sprint where project.id = " + projeto.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Sprint.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
