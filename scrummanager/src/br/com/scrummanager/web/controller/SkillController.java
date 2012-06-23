package br.com.scrummanager.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Knowledge;
import br.com.scrummanager.model.People;
import br.com.scrummanager.model.Skill;
import br.com.scrummanager.service.KnowledgeService;
import br.com.scrummanager.service.PeopleService;
import br.com.scrummanager.service.SkillService;

@Controller
public class SkillController {

	private Skill skill;
	@Resource
	SkillService skillService;
	private List<Skill> peopleWithThisSkillList;
	private List<People> people;
	private List<Skill> skillsOfAPersonList;
	private List<SelectItem> levelsList;
	private List<SelectItem> knowledgeCombo;
	private List<SelectItem> peopleCombo;
	private List<Knowledge> knowledgeList;
	@Resource
	KnowledgeService knowledgeService;
	@Resource
	PeopleService peopleService;
	boolean renderiza;

	public String newSkill() {
		skill = new Skill();
		skill.setKnowledge(new Knowledge());
		skill.setPeople(new People());
		refresh();
		return "skill";
	}

	public void refresh() {
		knowledgeList = knowledgeService.listAll();
		people = peopleService.listarTodos();
	}

	public void save() {
		skill.setPeople(peopleService.procurarPor(getSkill().getPeople()));
		skill.setKnowledge(knowledgeService.procurarPor(skill.getKnowledge()));
		skillService.save(skill);
		skillsOfAPersonList = skillService.procurarPorPessoa(getSkill()
				.getPeople());
		skill = new Skill();
		skill.setKnowledge(new Knowledge());
		skill.setPeople(new People());
		refresh();
	}

	public void delete() {
		skillService.delete(skill);
		skillsOfAPersonList = skillService.procurarPorPessoa(getSkill()
				.getPeople());
		refresh();
	}

	public String showSearchPeople() {
		skill = new Skill();
		skill.setKnowledge(new Knowledge());
		skill.setPeople(new People());
		renderiza = false;
		return "searchPeople";
	}

	public void seachSkill() {
		peopleWithThisSkillList = skillService.procurarPorHabilidades(
				skill.getKnowledge(), skill.getLevel());
		people = new ArrayList<People>();
		for (int i = 0; i < peopleWithThisSkillList.size(); i++) {
			Skill skill = peopleWithThisSkillList.get(i);
			People p = skill.getPeople();
			p = peopleService.procurarPor(p);
			people.add(p);
		}
		renderiza = true;
	}

	public void seachSkillsOfAPerson() {
		renderiza = true;
		skillsOfAPersonList = skillService.procurarPorPessoa(getSkill()
				.getPeople());
		refresh();
	}

	public List<SelectItem> getLevels() {
		levelsList = new ArrayList<SelectItem>();
		levelsList.add(new SelectItem("Júnior"));
		levelsList.add(new SelectItem("Pleno"));
		levelsList.add(new SelectItem("Senior"));
		return levelsList;
	}

	public List<SelectItem> getKnowledgeCombo() {
		knowledgeCombo = new ArrayList<SelectItem>();
		knowledgeList = knowledgeService.listAll();
		if (knowledgeList != null) {
			for (Knowledge knowledge : getKnowledgeList()) {
				knowledgeCombo.add(new SelectItem(knowledge.getId(), knowledge
						.getName()));
			}
		}
		return knowledgeCombo;
	}

	public List<SelectItem> getPeopleCombo() {
		peopleCombo = new ArrayList<SelectItem>();
		if (getPeople() != null) {
			for (People people : getPeople()) {
				peopleCombo
						.add(new SelectItem(people.getId(), people.getName()));
			}
		}
		return peopleCombo;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public List<Skill> getPeopleWithThisSkillList() {
		return peopleWithThisSkillList;
	}

	public List<Skill> getSkillsOfAPersonList() {
		return skillsOfAPersonList;
	}

	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public List<People> getPeople() {
		return people;
	}

	public boolean isRenderiza() {
		return renderiza;
	}
}
