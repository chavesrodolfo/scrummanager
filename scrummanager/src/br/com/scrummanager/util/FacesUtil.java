package br.com.scrummanager.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe utilitária para desenvolvimento JSF
 * @author Rodolfo
 * @since 11/02/2011
 */
public class FacesUtil {
	
	/**
	 * Métodos para obter informações sobre a sessão
	 * @return session
	 */
	@SuppressWarnings("rawtypes")
	public static Map getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}
	
	public static String getRequestParameter(String name) {
		return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
	
	public static ServletContext getServletContext() {
		return (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
	}
	
	public static HttpServletRequest getServletRequest() {
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public static HttpServletResponse getServletResponse() {
		return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Métodos para inserir mensagens na tela
	 * @param severity
	 * @param mensagem
	 */
	private static void exibirMensagem(FacesMessage.Severity severity, String mensagem) {
		FacesMessage facesMessage = new FacesMessage(severity, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public static void exibirMensagemSucesso(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_INFO, mensagem);
	}

	public static void exibirMensagemAlerta(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_WARN, mensagem);
	}
	
	public static void exibirMensagemErro(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_ERROR, mensagem);
	}
	
	public static void exibirMensagemFatal(String mensagem) {
		exibirMensagem(FacesMessage.SEVERITY_FATAL, mensagem);
	}

	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
}

