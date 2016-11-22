package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.OrganizationFacade;
import com.facade.ProvovFormaFacade;
import com.facade.UserFacade;
import com.model.Organization;
import com.model.ProvovForma;
import com.model.User;

@ViewScoped
@ManagedBean
public class OrganizationMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Organization organization;

	private List<ProvovForma> provovFormas;

	private List<Organization> organizations;

	private OrganizationFacade organizationFacade;
	
	private List<User> users;
	private UserFacade userFacade;
	

	private ProvovFormaFacade provovFormaFacade = new ProvovFormaFacade();

	public void createOrganization() {
		getOrganizationFacade().createOrganization(organization);
		closeDialog();
		displayInfoMessageToUser("Created With Sucess");
		loadOrganizations();
		resetOrganization();
	}

	public void deleteOrganization() {
		getOrganizationFacade().deleteOrganization(organization);
		closeDialog();
		displayInfoMessageToUser("Deleted With Sucess");
		loadOrganizations();
		resetOrganization();
	}

	public Organization getOrganization() {
		if (organization == null) {
			organization = new Organization();
		}
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public OrganizationFacade getOrganizationFacade() {
		if (organizationFacade == null) {
			organizationFacade = new OrganizationFacade();
		}
		return organizationFacade;
	}

	private void loadOrganizations() {
		organizations = getOrganizationFacade().listAll();
	}

	public void resetOrganization() {
		organization = new Organization();
	}

	public List<Organization> getAllOrganizations() {
		if (organizations == null) {
			loadOrganizations();
		}
		return organizations;
	}

	public List<ProvovForma> getProvovFormas() {
		if (provovFormas == null) {
			loadProvovFormas();
		}
		return provovFormas;
	}

	public void loadProvovFormas() {
		provovFormas = provovFormaFacade.listAll();
	}

	public ProvovFormaFacade getProvovFormaFacade() {
		if (provovFormaFacade == null) {
			provovFormaFacade = new ProvovFormaFacade();
		}
		return provovFormaFacade;
	}
	
	public List<User> getUsers(){
		if(users == null){
			loadUsers();
		}
		return users;
	}
	public void loadUsers(){
		users = getUserFacade().listAll();
	}
	public UserFacade getUserFacade(){
		if(userFacade == null){
		userFacade = new UserFacade();
		}
		return userFacade;
	}

}
