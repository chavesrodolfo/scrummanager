package br.com.scrummanager.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.scrummanager.model.Knowledge;
import br.com.scrummanager.service.KnowledgeService;

@Controller
public class KnowledgeController {

	private Knowledge knowledge;

	private List<Knowledge> knowledgeList;

	@Resource
	KnowledgeService knowledgeService;

	public String newKnowledge() {
		refresh();
		return "knowledge";
	}

	public void refresh() {
		knowledge = new Knowledge();
		knowledgeList = new ArrayList<Knowledge>();
		knowledgeList = knowledgeService.listAll();
	}
	
	public void save(){
		knowledgeService.save(knowledge);
		refresh();
	}
	
	public void delete(){
		knowledgeService.delete(knowledge);
		refresh();
	}
	
	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

}
