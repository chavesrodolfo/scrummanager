package br.com.scrummanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.User;

@Service
public class UserService{
	
	public List<User> listarTodos() {
		try {
			return JPAGenericDAO.getInstance().listAll(User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void gravar(User User) {
		try {
			JPAGenericDAO.getInstance().merge(User);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(User user) {
		try {
			JPAGenericDAO.getInstance().remove(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User procurarPor(User user) {
		try {
			return JPAGenericDAO.getInstance().find(User.class, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> procurarPorLogin(String user) {
		String hql = "from User user where user.login = '" + user+"'";
		try {
			return JPAGenericDAO.getInstance().findHql(User.class, hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
