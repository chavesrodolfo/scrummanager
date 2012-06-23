package br.com.scrummanager.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.model.Requirement;
import br.com.scrummanager.model.Sprint;
import br.com.scrummanager.service.RequirementService;
import br.com.scrummanager.service.SprintService;

@Controller
@Scope("session")
public class SprintController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sprint sprint;

	private List<Sprint> listaTodasSprints;
	private List<Sprint> listaSprintsDeUmProjeto;
	private List<Requirement> selectedPBList;
	private Project selectedProject;
	private List<Requirement> requirementsProject;
	@Resource
	private SprintService sprintService;
	@Resource
	private ProjectController projectController;
	@Resource
	private RequirementService requirementService;
	boolean showSelectedPB;
	boolean showRequirements;
	private Requirement[] selectedRequirements;

	public String newSprint() {
		setSelectedProject(projectController.getProject());
		atualizarTela();
		return "sprint";
	}

	public void atualizarTela() {
		sprint = new Sprint();
		sprint.setProject(getSelectedProject());
		listaTodasSprints = sprintService.listarTodos();
		listaSprintsDeUmProjeto = sprintService
				.procurarPorProjeto(getSelectedProject());
	}

	public String showSelectedPB() {
		selectedPBList = requirementService.procurarPorSprint(getSprint());
		if (selectedPBList.isEmpty()) {
			showSelectedPB = false;
			showRequirements = true;
		}else{
			showSelectedPB = true;
			showRequirements = false;
		}
		requirementsProject = requirementService
				.procurarPorProjeto(getSelectedProject());
		return "selectedPB";
	}
	
	public String editSelectedPB(){
		showSelectedPB = false;
		showRequirements = true;
		return "selectedPB";
	}

	public String buildSelectedPB() {
		selectedPBList = new ArrayList<Requirement>();
		for (int i = 0; i < getSelectedRequirements().length; i++) {
			Requirement req = getSelectedRequirements()[i];
			selectedPBList.add(req);
			
		}
		sprint.setRequirements(selectedPBList);
		sprintService.gravar(getSprint());
		showSelectedPB = true;
		showRequirements = false;
		return "selectedPB";
	}

	/**
	 * Salva registro
	 */
	public String gravar() {
		if (!sprint.getIdentification().equals(StringUtils.EMPTY)) {
			sprintService.gravar(getSprint());
			atualizarTela();
		} else {
			MessagesController.msgFormIncorreto();
		}
		return "sprint";
	}

	/**
	 * Exclui um registro da tabela sprint
	 */
	public void excluir() {
		sprintService.excluir(getSprint());
		atualizarTela();
	}

	public String entrar() {
		return "sprintMenu";
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public List<Sprint> getListaTodasSprints() {
		return listaTodasSprints;
	}

	public List<Sprint> getListaSprintsDeUmProjeto() {
		return listaSprintsDeUmProjeto;
	}

	public Project getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}

	public List<Requirement> getRequirementsProject() {
		return requirementsProject;
	}

	public void setRequirementsProject(List<Requirement> requirementsProject) {
		this.requirementsProject = requirementsProject;
	}

	public List<Requirement> getSelectedPBList() {
		return selectedPBList;
	}

	public Requirement[] getSelectedRequirements() {
		return selectedRequirements;
	}

	public void setSelectedRequirements(Requirement[] selectedRequirements) {
		this.selectedRequirements = selectedRequirements;
	}
	
	public boolean isShowRequirements() {
		return showRequirements;
	}
	
	public boolean isShowSelectedPB() {
		return showSelectedPB;
	}
}
