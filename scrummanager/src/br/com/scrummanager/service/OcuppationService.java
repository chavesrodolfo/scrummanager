package br.com.scrummanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Ocuppation;

@Service
public class OcuppationService {
	
	public List<Ocuppation> listAll() {
		try {
			return JPAGenericDAO.getInstance().listAll(Ocuppation.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Ocuppation ocuppation) {
		try {
			JPAGenericDAO.getInstance().merge(ocuppation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Ocuppation ocuppation) {
		try {
			JPAGenericDAO.getInstance().remove(ocuppation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
