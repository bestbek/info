package com.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.facade.OrganizationFacade;
import com.model.Organization;

/**
 * 
 * @author Mickey 
 * required for select menu
 */
@FacesConverter(forClass = com.model.Organization.class, value = "organizationConverter")
public class OrganizationConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		OrganizationFacade organizationFacade = new OrganizationFacade();
		int organId;
		try
		{
			organId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception)
		{
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Type the name of a organization and select it (or use the dropdow)",
					"Type the name of a Organization and select it (or use the dropdow)"));
		}
		return organizationFacade.getOrganization(organId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{

		if (arg2 == null)
		{
			return null;
		}
		Organization organization = (Organization) arg2;
		return String.valueOf(organization.getId());
	}

}
