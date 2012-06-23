package br.com.scrummanager.web.security;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

import br.com.scrummanager.util.FacesUtil;
import br.com.scrummanager.util.LoggerUtil;

/**
 * PhaseListener utilizado para capturar exceções de autenticação
 *
 */
public class LoginErrorPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void beforePhase(PhaseEvent arg0) {
		Exception dadosIncorretosException = (Exception) FacesUtil.getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(dadosIncorretosException instanceof BadCredentialsException) {
			FacesUtil.getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesUtil.exibirMensagemErro("Dados incorretos!");
			LoggerUtil.warn("Dados incorretos durante Login.", getClass());
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
