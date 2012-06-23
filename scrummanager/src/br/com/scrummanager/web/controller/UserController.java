package br.com.scrummanager.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.scrummanager.model.User;
import br.com.scrummanager.service.UserService;
import br.com.scrummanager.util.Constants;

@Controller
@Scope("session")
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	private User usuario;
	private List<User> listaUsuarios;

	private List<SelectItem> autoridades;
	private String confirmacaoSenha;

	@Resource
	private UserService usuarioService;
	
	public String start() {
		atualizarTela();
		return "cadastroUsuario";
	}

	/**
	 * Limpa os campos input e atualiza a lista de usuários cadastrados
	 */
	public void atualizarTela() {
		usuario = new User();
		listaUsuarios = new ArrayList<User>();
		confirmacaoSenha = "";
		listaUsuarios = usuarioService.listarTodos();
	}

	/**
	 * Grava novo registro ou atualiza um registro
	 */
	public void gravar() {
		try {
			if (usuario.getPassword().equals(confirmacaoSenha)
					&& !usuario.getEmail().isEmpty()
					&& !usuario.getLogin().isEmpty()
					&& !usuario.getName().isEmpty()
					&& !usuario.getPassword().isEmpty()) {

				usuarioService.gravar(getUsuario());
				MessagesController.msgUsuarioCadastrado();
				atualizarTela();
			} else if (!usuario.getPassword().equals(confirmacaoSenha)) {
				MessagesController.msgSenhaNaoConfere();
			} else {
				MessagesController.msgFormIncorreto();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Exclui um registro da tabela usuario
	 */
	public void excluir() {
		usuarioService.excluir(getUsuario());
		atualizarTela();
	}

	public List<User> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public User procuraPor(User usuario) {
		return this.usuarioService.procurarPor(usuario);
	}

	public void setListaUsuarios(List<User> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public void setAutoridades(List<SelectItem> autoridades) {
		this.autoridades = autoridades;
	}

	public List<SelectItem> getAutoridades() {
		this.autoridades = new ArrayList<SelectItem>();
		this.autoridades.add(new SelectItem(Constants.PERFIL_USER));
		this.autoridades.add(new SelectItem(Constants.PERFIL_ADMIN));
		return autoridades;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	
}
