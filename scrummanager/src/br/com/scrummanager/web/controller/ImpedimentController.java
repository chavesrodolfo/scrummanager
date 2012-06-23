package br.com.scrummanager.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.scrummanager.model.Impediment;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.model.Requirement;
import br.com.scrummanager.service.ImpedimentService;
import br.com.scrummanager.service.RequirementService;

@Controller
@Scope("session")
public class ImpedimentController {
	
	private Impediment impediment;
	private Requirement requirement;
	
	@Resource
	private ImpedimentService impedimentService;
	@Resource
	private ProjectController projectController;
	@Resource
	private RequirementController requirementController;
	private List<Impediment> impedimentsProject;
	private Project selectedProject;
	private Requirement selectedRequirement;
	private List<String> statusList;
	private List<SelectItem> requirementsProjectCombo;
	@Resource
	private RequirementService requirementService;
	private List<Requirement> requirementsProject;
	
	public String newImpediment(){
		setSelectedProject(projectController.getProject());
		refresh();
		return "impediment";
	}

	public void refresh() {
		impediment = new Impediment();
		impediment.setRequirement(new Requirement());
		impediment.setProject(getSelectedProject());
		impediment.setRegistrationDate(new Date());
		requirementsProject = requirementService.procurarPorProjeto(getSelectedProject());
		impedimentsProject = impedimentService.procurarPorProjeto(getSelectedProject());
	}
	
	/**
	 * Salva registro
	 */
	public String gravar() {
		
		if (StringUtils.isNotBlank(impediment.getIdentification())) {
			requirement = requirementService.findById(impediment.getRequirement().getId());
			impediment.setRequirement(requirement);
			impedimentService.gravar(getImpediment());
			MessagesController.msgImpedimentSaved();
			refresh();
		} else {
			MessagesController.msgFormIncorreto();
		}
		return "impediment";
	}
	
	/**
	 * Exclui um registro da tabela sprint
	 */
	public void excluir() {
		impedimentService.excluir(getImpediment());
		refresh();
	}
	
	public List<String> getStatusList(){
		if(statusList == null){
			statusList = new LinkedList<String>();
            statusList.add("Pendente");
            statusList.add("Resolvido");
            statusList.add("Postergado");

		}
		return statusList;
	}
	
	public List<SelectItem> getRequirements() {
		requirementsProjectCombo = new ArrayList<SelectItem>();
		if(getRequirementsProject() != null){
			for(Requirement requirement : getRequirementsProject()){
	        	requirementsProjectCombo.add(new SelectItem(requirement.getId(),requirement.getIdentification()));
	        }
		}
        return requirementsProjectCombo;
	}
	
	public Project getSelectedProject() {
		return selectedProject;
	}
	
	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
	
	public Requirement getSelectedRequirement() {
		return selectedRequirement;
	}
	
	public void setSelectedRequirement(Requirement selectedRequirement) {
		this.selectedRequirement = selectedRequirement;
	}
	
	public Impediment getImpediment() {
		return impediment;
	}
	
	public void setImpediment(Impediment impediment) {
		this.impediment = impediment;
	}
	
	public List<Impediment> getImpedimentsProject() {
		return impedimentsProject;
	}
	
	public RequirementController getRequirementController() {
		return requirementController;
	}
	
	public List<Requirement> getRequirementsProject() {
		return requirementsProject;
	}
	
}
