package br.com.scrummanager.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.People;
import br.com.scrummanager.model.Project;
import br.com.scrummanager.service.ProjectService;

@Controller
@Scope("session")
public class ProjectController {

	private Project project;

	private List<Project> listaProjetos;
	private List<SelectItem> peopleProjectCombo;
	private List<People> peopleProject;

	@Resource
	private ProjectService projectService;
	

//	private List<SelectItem> comboProjetos;

	public String newProject(){
		atualizarTela();
		return "project";
	}

	public String painelUsuario(){
		atualizarTela();
		return "painelUsuario.xhtml";
	}

	public void atualizarTela() {
		project = new Project();
		listaProjetos = new ArrayList<Project>();
		listaProjetos = projectService.listarTodos();
	}

	/**
	 * Salva registro
	 */
	public String gravar() {
		System.out.println("Entrou no gravar!");
		if (!project.getIdentification().equals(StringUtils.EMPTY)) {
			projectService.gravar(getProject());
			MessagesController.msgProjetoCadastrado();
			atualizarTela();
		} else {
			MessagesController.msgFormIncorreto();
		}
		return "project";
	}

	/**
	 * Exclui um registro da tabela project
	 */
	public void excluir() {
		projectService.excluir(getProject());
		atualizarTela();
	}

	public List<SelectItem> getPeoples() {
		peopleProjectCombo = new ArrayList<SelectItem>();
		if(getPeopleProject() != null){
			for(People people : getPeopleProject()){
				peopleProjectCombo.add(new SelectItem(people.getId(),people.getName()));
	        }
		}
        return peopleProjectCombo;
	}

	public String entrar() {
		return "projectMenu";
	}

	public Project getProject() {
		return project;
	}

	public List<Project> getListaProjetos() {
		return listaProjetos;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public List<People> getPeopleProject() {
		return peopleProject;
	}
	
	
}
