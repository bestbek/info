package com.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.facade.UserFacade;
import com.model.User;

/**
 * 
 * @author Mickey 
 * required for select menu
 */
@FacesConverter(forClass = com.model.User.class, value = "userConverter")
public class UserConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		UserFacade userFacade = new UserFacade();
		int userId;
		try
		{
			userId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception)
		{
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Type the name of a User and select it (or use the dropdow)",
					"Type the name of a User and select it (or use the dropdow)"));
		}
		return userFacade.findUser(userId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{
		if (arg2 == null)
		{
			return null;
		}
		User user = (User) arg2;
		return String.valueOf(user.getId());
	}
}
