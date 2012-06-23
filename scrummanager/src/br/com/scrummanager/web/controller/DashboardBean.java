package br.com.scrummanager.web.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class DashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DashboardModel model;
	
	public DashboardBean() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();
		DashboardColumn column3 = new DefaultDashboardColumn();

		column1.addWidget("sports");
		column1.addWidget("finance");
		
		column2.addWidget("lifestyle");
		column2.addWidget("weather");
		
		column3.addWidget("politics");

		model.addColumn(column1);
		model.addColumn(column2);
		model.addColumn(column3);
	}
	
	public void handleReorder(DashboardReorderEvent event) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Mudança de Status: " + event.getWidgetId());
		message.setDetail("Item: " + event.getItemIndex() + ", Origem: " + event.getSenderColumnIndex() + ", Destino: " + event.getColumnIndex());
		
		addMessage(message);
	}
	
	public void handleClose(CloseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Task Fechada", "Id da Task:'" + event.getComponent().getId() + "'");
		
		addMessage(message);
	}
	
	public void handleToggle(ToggleEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
		
		addMessage(message);
	}
	
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public DashboardModel getModel() {
		return model;
	}
}
			