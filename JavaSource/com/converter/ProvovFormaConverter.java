package com.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.facade.ProvovFormaFacade;
import com.model.ProvovForma;

/**
 * 
 * @author Mickey 
 * required for select menu
 */
@FacesConverter(value = "provovFormaConverter", forClass = com.model.ProvovForma.class)
public class ProvovFormaConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
	{
		int provovFormaId;
		ProvovFormaFacade provovFormaFacade = new ProvovFormaFacade();
		try
		{
			provovFormaId = Integer.parseInt(arg2);

		} catch (NumberFormatException exception)
		{
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Type the name of a ProvovForma and select it (or use the dropdow)",
					"Type the name of a ProvovForma and select it (or use the dropdow)"));
		}

		return provovFormaFacade.findProvovForma(provovFormaId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
	{
		if (arg2 == null)
		{
			return null;
		}
		ProvovForma provovForma = (ProvovForma) arg2;
		return String.valueOf(provovForma.getId());
	}
}
