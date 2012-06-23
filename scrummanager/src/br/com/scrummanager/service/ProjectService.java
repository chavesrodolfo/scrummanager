/**
 *
 */
package br.com.scrummanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Project;

@Service
public class ProjectService{

	public List<Project> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(Project.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(Project Project) {
		try {
			JPAGenericDAO.getInstance().merge(Project);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Project project) {
		try {
			JPAGenericDAO.getInstance().remove(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Project procurarPor(Project project) {
		try {
			return JPAGenericDAO.getInstance().find(Project.class,
					project.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}


}
