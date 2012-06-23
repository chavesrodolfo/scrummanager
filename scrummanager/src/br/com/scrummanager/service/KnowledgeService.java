package br.com.scrummanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Knowledge;

@Service
public class KnowledgeService {

	public List<Knowledge> listAll() {
		try {
			return JPAGenericDAO.getInstance().listAll(Knowledge.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Knowledge knowledge) {
		try {
			JPAGenericDAO.getInstance().merge(knowledge);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Knowledge knowledge) {
		try {
			JPAGenericDAO.getInstance().remove(knowledge);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Knowledge procurarPor(Knowledge knowledge) {
		try {
			return JPAGenericDAO.getInstance().find(Knowledge.class,
					knowledge.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return knowledge;
	}

}
