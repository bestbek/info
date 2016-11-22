package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.facade.UserFacade;
import com.model.Role;
import com.model.User;

@SessionScoped
@ManagedBean(name = "userMB")
public class UserMB extends AbstractMB implements Serializable
{
	public static final String INJECTION_NAME = "#{userMB}";
	private static final long serialVersionUID = 1L;

	private User user;
	private UserFacade userFacade;
	private List<User> users;

	public void createUser()
	{
		user.setRole(Role.ORGANIZATION);
		getUserFacade().createUser(user);
		closeDialog();
		displayInfoMessageToUser("Created With Sucess");
		loadUsers();
		resetUser();
	}

	public void updateUser()
	{
		getUserFacade().updateUser(user);
		closeDialog();
		displayInfoMessageToUser("Updated With Sucess");
		loadUsers();
		resetUser();
	}

	public void resetUser()
	{
		user = new User();
		user.setRole(Role.ADMIN);
	}

	public void loadUsers()
	{
		users = getUserFacade().listAll();
	}

	public boolean isAdmin()
	{
		return user.isAdmin();
	}

	public boolean isDefaultUser()
	{
		return user.isOrganization();
	}

	public String logOut()
	{
		getRequest().getSession().invalidate();
		return "/pages/public/login.xhtml";
	}

	private HttpServletRequest getRequest()
	{
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public UserFacade getUserFacade()
	{
		if (userFacade == null)
		{
			userFacade = new UserFacade();
		}
		return userFacade;
	}

	public List<User> getAllUsers()
	{
		if (users == null)
		{
			loadUsers();
		}
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	public void setUserFacade(UserFacade userFacade)
	{
		this.userFacade = userFacade;
	}

	public void deleteUser()
	{
		try
		{
			getUserFacade().deleteUser(user);
			closeDialog();
			displayInfoMessageToUser("Deleted With Sucess");
			loadUsers();
			resetUser();
		} catch (Exception e)
		{
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not delete. Try again later");
			e.printStackTrace();
		}
	}

	// public List<Organization> getOrganizations() {
	// if (organizations == null) {
	// loadOrganizations();
	// }
	// return organizations;
	//
	// }
	//
	// public void loadOrganizations() {
	// organizations = getOrganizationFacade().listAll();
	// }
	// public OrganizationFacade getOrganizationFacade(){
	// if(organizationFacade == null){
	// organizationFacade = new OrganizationFacade();
	// }
	// return organizationFacade;
	// }
}