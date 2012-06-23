package br.com.scrummanager.web.controller;

import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import br.com.scrummanager.util.FacesUtil;

@Controller
public class MessagesController {

	public static void msgUsuarioCadastrado() {
		FacesUtil.exibirMensagemSucesso("Usu�rio Cadastrado com Sucesso!");
	}

	public static void msgSenhaNaoConfere() {
		FacesUtil.exibirMensagemErro("Senha n�o confere.");
	}

	public static void msgExclusao(ActionEvent actionEvent) {
		FacesUtil.exibirMensagemSucesso("Exclus�o realizada com sucesso.");
	}

	public static void msgFormIncorreto() {
		FacesUtil.exibirMensagemAlerta("Preencha o Formul�rio de cadastro corretamente. Os campos sinalizados com asterisco(*) s�o obrigat�rios.");
	}
	
	public static void msgProjetoCadastrado() {
		FacesUtil.exibirMensagemSucesso("Projeto Cadastrado com Sucesso!");
	}
	
	public static void msgSprintCadastrada() {
		FacesUtil.exibirMensagemSucesso("Sprint Cadastrada com Sucesso!");
	}
	
	public static void msgTarefaCadastrada() {
		FacesUtil.exibirMensagemSucesso("Tarefa Cadastrada com Sucesso!");
	}
	
	public static void msgRequirementSaved() {
		FacesUtil.exibirMensagemSucesso("Requisito Cadastrado com Sucesso!");
	}
	
	public static void msgImpedimentSaved() {
		FacesUtil.exibirMensagemSucesso("Impedimento Cadastrado com Sucesso!");
	}
	
	public static void msgConferenceSaved() {
		FacesUtil.exibirMensagemSucesso("Reuni�o Cadastrada com Sucesso!");
	}
	
}
