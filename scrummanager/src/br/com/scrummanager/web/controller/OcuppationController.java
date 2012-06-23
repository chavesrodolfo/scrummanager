package br.com.scrummanager.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import br.com.scrummanager.model.Ocuppation;
import br.com.scrummanager.service.OcuppationService;

@Controller
public class OcuppationController {
	
	private Ocuppation ocuppation;

	private List<Ocuppation> ocuppationList;

	@Resource
	OcuppationService ocuppationService;

	public String newOcuppation() {
		refresh();
		return "ocuppation";
	}

	public void refresh() {
		ocuppation = new Ocuppation();
		ocuppationList = new ArrayList<Ocuppation>();
		ocuppationList = ocuppationService.listAll();
	}
	
	public void save(){
		ocuppationService.save(ocuppation);
		refresh();
	}
	
	public void delete(){
		ocuppationService.delete(ocuppation);
		refresh();
	}
	
	public Ocuppation getOcuppation() {
		return ocuppation;
	}
	
	public void setOcuppation(Ocuppation ocuppation) {
		this.ocuppation = ocuppation;
	}

	public List<Ocuppation> getOcuppationList() {
		return ocuppationList;
	}
	
	public void setOcuppationList(List<Ocuppation> ocuppationList) {
		this.ocuppationList = ocuppationList;
	}

}
