package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.ProvovFormaFacade;
import com.model.ProvovForma;
@ViewScoped
@ManagedBean(name="pfMB")
public class ProvovFormaMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProvovForma provovForma;
	private List<ProvovForma> provovFormas;
	private ProvovFormaFacade provovFormaFacade;

	
	public void createProvovForma(){
		getProvovFormaFacade().createProvovForma(provovForma);
		closeDialog();
		displayInfoMessageToUser("Created With Sucess");
		loadProvovFormas();
		resetProvovForma();
	}
	public void deleteProvovForma(){
		getProvovFormaFacade().deleteProvovForma(provovForma);
		closeDialog();
		displayInfoMessageToUser("Deleted With Sucess");
		loadProvovFormas();
		resetProvovForma();
	}
	public void updateProvovForma(){
		getProvovFormaFacade().updateProvovForma(provovForma);
		closeDialog();
		displayInfoMessageToUser("Updated With Sucess");
		loadProvovFormas();
		resetProvovForma();
	}
	
	public void resetProvovForma() {
		provovForma = new ProvovForma();
	}

	public ProvovForma getProvovForma() {
		if (provovForma == null) {
			provovForma = new ProvovForma();
		}
		return provovForma;
	}

	public void setProvovForma(ProvovForma provovForma) {
		this.provovForma = provovForma;
	}
	
	public ProvovFormaFacade getProvovFormaFacade() {
		if (provovFormaFacade == null) {
			provovFormaFacade = new ProvovFormaFacade();
		}
		return provovFormaFacade;
	}
	
	public List<ProvovForma> getAllProvovFormas(){
		if (provovFormas == null) {
			loadProvovFormas();
		}
		return provovFormas;
	}
	
	private void loadProvovFormas() {
		provovFormas = getProvovFormaFacade().listAll();
	}
	
}
