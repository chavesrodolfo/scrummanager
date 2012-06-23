package br.com.scrummanager.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Skill;
import br.com.scrummanager.model.People;
import br.com.scrummanager.service.PeopleService;

@Controller
public class PeopleController {

	private People people;
	private List<People> listPeoples;
	private List<Skill> listAbilities;

	@Resource
	private PeopleService peopleService;

	public String newPeople() {
		atualizarTela();
		return "people";
	}
	
	public void atualizarTela() {
		people = new People();
		listAbilities = new ArrayList<Skill>();
		people.setAbilities(listAbilities);
		listPeoples = peopleService.listarTodos();
	}
	
	public void gravar(){
		peopleService.gravar(people);
		newPeople();
	}
	
	public void excluir(){
		peopleService.excluir(people);
		newPeople();
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public List<People> getListPeoples() {
		return listPeoples;
	}

	public void setListPeoples(List<People> listPeoples) {
		this.listPeoples = listPeoples;
	}

	public List<Skill> getListAbilities() {
		return listAbilities;
	}

	public void setListAbilities(List<Skill> listAbilities) {
		this.listAbilities = listAbilities;
	}

	public PeopleService getPeopleService() {
		return peopleService;
	}

	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

}
