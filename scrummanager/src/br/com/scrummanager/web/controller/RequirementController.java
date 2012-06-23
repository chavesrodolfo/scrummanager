package br.com.scrummanager.web.controller;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.model.Requirement;
import br.com.scrummanager.service.RequirementService;

@Controller
@Scope("session")
public class RequirementController {
	
	private Requirement requirement;
	
	@Resource
	private RequirementService requirementService;
	@Resource
	private ProjectController projectController;
	private List<Requirement> requirementsProject;
	
	private Project selectedProject;
	private List<String> statusList;
	
	public String newRequirement(){
		setSelectedProject(projectController.getProject());
		atualizarTela();
		return "requirement";
	}

	public void atualizarTela() {
		requirement = new Requirement();
		requirement.setProject(getSelectedProject());
		requirementsProject = requirementService.procurarPorProjeto(getSelectedProject());
	}
	
	/**
	 * Salva registro
	 */
	public String gravar() {
		if (!requirement.getIdentification().equals(StringUtils.EMPTY)) {
			requirementService.gravar(getRequirement());
			MessagesController.msgRequirementSaved();
			atualizarTela();
		} else {
			MessagesController.msgFormIncorreto();
		}
		return "requirement";
	}


	/**
	 * Exclui um registro da tabela sprint
	 */
	public void excluir() {
		requirementService.excluir(getRequirement());
		atualizarTela();
	}
	
	public Project getSelectedProject() {
		return selectedProject;
	}
	
	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}
	
	public Requirement getRequirement() {
		return requirement;
	}
	
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	
	public List<Requirement> getRequirementsProject() {
		return requirementsProject;
	}
	
	public List<String> getStatusList(){
		if(statusList == null){
			statusList = new LinkedList<String>();
            statusList.add("Pendente");
            statusList.add("Executando");
            statusList.add("Feito");

		}
		return statusList;
	}
}
