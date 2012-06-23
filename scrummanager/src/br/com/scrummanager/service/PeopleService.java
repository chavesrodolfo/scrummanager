package br.com.scrummanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.People;

@Service
public class PeopleService{

	public List<People> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(People.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(People people) {
		try {
			JPAGenericDAO.getInstance().merge(people);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(People people) {
		try {
			JPAGenericDAO.getInstance().remove(people);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public People procurarPor(People people) {
		try {
			return JPAGenericDAO.getInstance().find(People.class,
					people.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return people;
	}


}
