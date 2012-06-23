package br.com.scrummanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Sprint;
import br.com.scrummanager.model.Task;

@Service
public class TaskService{

	public List<Task> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(Task.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(Task Task) {
		try {
			JPAGenericDAO.getInstance().merge(Task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Task task) {
		try {
			JPAGenericDAO.getInstance().remove(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Task procurarPor(Task task) {
		try {
			return JPAGenericDAO.getInstance().find(Task.class,
					task.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

	public List<Task> procurarPorSprint(Sprint sprint) {
		String hql = "from Task where sprint.id = " + sprint.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Task.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
