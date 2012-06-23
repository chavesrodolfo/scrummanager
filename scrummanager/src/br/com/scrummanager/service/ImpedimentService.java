package br.com.scrummanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Impediment;
import br.com.scrummanager.model.Project;

@Service
public class ImpedimentService {
	
	public List<Impediment> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(Impediment.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(Impediment impediment) {
		try {
			JPAGenericDAO.getInstance().merge(impediment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Impediment impediment) {
		try {
			JPAGenericDAO.getInstance().remove(impediment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Impediment procurarPor(Impediment impediment) {
		try {
			return JPAGenericDAO.getInstance().find(Impediment.class,
					impediment.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return impediment;
	}

	public List<Impediment> procurarPorProjeto(Project projeto) {
		String hql = "from Impediment where project.id = " + projeto.getId();
		try {
			return JPAGenericDAO.getInstance().findHql(Impediment.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
