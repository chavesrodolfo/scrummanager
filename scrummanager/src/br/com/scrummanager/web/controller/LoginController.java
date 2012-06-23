package br.com.scrummanager.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.scrummanager.model.User;
import br.com.scrummanager.service.UserService;
import br.com.scrummanager.util.Constants;
import br.com.scrummanager.util.FacesUtil;
import br.com.scrummanager.util.LoggerUtil;

@Controller
@Scope("session")
public class LoginController {

	private List<User> usuarios;
	private String username;
	private String autoridade;
	private boolean admin;
	
	@Resource
	private UserService usuarioService;
	
	@Resource
	private UserController userController;
	
	@Resource
	private ProjectController projectController;

	public String logar() {
		try {
		    RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_check");
		    dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
		    FacesContext.getCurrentInstance().responseComplete();
		    
		    LoggerUtil.info(SecurityContextHolder.getContext().getAuthentication().getName() + " efetuou Login em " + new Date(), getClass());
		    
			usuarios = usuarioService.procurarPorLogin(SecurityContextHolder.getContext().getAuthentication().getName());
	        this.username = usuarios.get(0).getName();
	        this.autoridade = usuarios.get(0).getAuthority();
	        
	        projectController.newProject();
	        
	        if (this.autoridade.equals(Constants.PERFIL_ADMIN)){
	        	this.admin = true;
	        }
	        else{
	        	this.admin = false;
	        }
	        
		    userController.start();
		    
		} catch (Exception ex) {
			FacesUtil.exibirMensagemErro(ex.getMessage());
			return null;
		}
	    return "painelUsuario";
	}
	
	public String logout() {
		try {
			RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_logout");
			dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			FacesUtil.exibirMensagemErro("Erro ao sair do sistema");
			return null;
		}
		return null;
	}

	public String getUsername() {
		return this.username;
	}
	
	public boolean getAdmin(){
		return this.admin;
	}
}
