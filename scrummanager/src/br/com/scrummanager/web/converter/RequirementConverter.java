package br.com.scrummanager.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.scrummanager.dao.JPAGenericDAO;
import br.com.scrummanager.model.Requirement;

@FacesConverter(value="requirementConverter")
public class RequirementConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		Integer code = Integer.parseInt(value);
		try {
			return JPAGenericDAO.getInstance().find(Requirement.class, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
		
	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object obj) {
		Requirement requirement = (Requirement)obj;
		return String.valueOf(requirement.getId());
	}

}
