package br.com.scrummanager.test;

import java.util.List;

import javax.annotation.Resource;

import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.User;
import br.com.scrummanager.service.UserService;

public class Test {

	@Resource
	private UserService userService;

	public List<User> listarUsuarios() {
		try {
			JPAGenericDAO.getInstance().listAll(User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) {
		Test teste = new Test();
		try {
			System.out.println(JPAGenericDAO.getInstance().listAll(User.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
