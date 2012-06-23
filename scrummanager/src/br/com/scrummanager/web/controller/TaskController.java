package br.com.scrummanager.web.controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Sprint;
import br.com.scrummanager.model.Task;
import br.com.scrummanager.service.TaskService;

@Controller
@Scope("session")
public class TaskController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Task task;
	private List<Task> listaTarefasDeUmaSprint;
	private Sprint selectedSprint;
	private List<String> statusList;
	private List<String> statusTestList;
	@Resource
	private TaskService taskService;
	@Resource
	private SprintController sprintController;


	public String newTask(){
		setSelectedSprint(sprintController.getSprint());
		atualizarTela();
		return "task";
	}
	
	public void atualizarTela() {
		task = new Task();
		task.setSprint(getSelectedSprint());
		listaTarefasDeUmaSprint = taskService.procurarPorSprint(getSelectedSprint());
	}
	
	public String gravar(){
		if(!task.getIdentification().equals(StringUtils.EMPTY)){
			taskService.gravar(getTask());
			MessagesController.msgTarefaCadastrada();
			atualizarTela();
		}else{
			MessagesController.msgFormIncorreto();
		}
		return "task";
	}
	
	/**
	 * Exclui um registro da tabela sprint
	 */
	public void excluir() {
		taskService.excluir(getTask());
		atualizarTela();
	}
	
	//cadastrar na tabela e fazer um List<SeletcItem>?
	public List<String> getStatusList(){
		if(statusList == null){
			statusList = new LinkedList<String>();
            statusList.add("Pendente");
            statusList.add("Executando");
            statusList.add("Feita");

		}
		return statusList;
	}
	
	public List<String> getStatusTestList(){
		if(statusTestList == null){
			statusTestList = new LinkedList<String>();
			statusTestList.add("Testada");
			statusTestList.add("Pendente");
		}
		return statusTestList;
	}

	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public List<Task> getListaTarefasDeUmaSprint() {
		return listaTarefasDeUmaSprint;
	}
	
	public void setListaTarefasDeUmaSprint(List<Task> listaTarefasDeUmaSprint) {
		this.listaTarefasDeUmaSprint = listaTarefasDeUmaSprint;
	}
	
	public Sprint getSelectedSprint() {
		return selectedSprint;
	}
	
	public void setSelectedSprint(Sprint selectedSprint) {
		this.selectedSprint = selectedSprint;
	}
}
