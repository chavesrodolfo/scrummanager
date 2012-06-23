package br.com.scrummanager.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Conference;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.service.ConferenceService;

@Controller
@Scope("session")
public class ConferenceController {
	
	private Conference conference;
	@Resource
	private ConferenceService conferenceService;
	@Resource
	private ProjectController projectController;
	private Project selectedProject;
	private List<Conference> conferencesProject;
	
	
	public String newConference(){
		setSelectedProject(projectController.getProject());
		atualizarTela();
		return "conference";
	}

	public void atualizarTela() {
		conference = new Conference();
		conference.setProject(getSelectedProject());
		conferencesProject = conferenceService.procurarPorProjeto(getSelectedProject());
	}
	
	/**
	 * Salva registro
	 */
	public String gravar() {
		if (!conference.getIdentification().equals(StringUtils.EMPTY)) {
			conferenceService.gravar(getConference());
			MessagesController.msgConferenceSaved();
			atualizarTela();
		} else {
			MessagesController.msgFormIncorreto();
		}
		return "conference";
	}

	public void excluir() {
		conferenceService.excluir(getConference());
		atualizarTela();
	}
	
	public Project getSelectedProject() {
		return selectedProject;
	}
	
	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
	
	public Conference getConference() {
		return conference;
	}
	
	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
	public List<Conference> getConferencesProject() {
		return conferencesProject;
	}
}
