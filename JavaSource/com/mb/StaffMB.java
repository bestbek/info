package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.OrganizationFacade;
import com.facade.StaffFacade;
import com.model.Organization;
import com.model.Staff;

@ViewScoped
@ManagedBean(name = "staffMB")
public class StaffMB extends AbstractMB implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Staff staff;
	private List<Staff> staffs;
	private List<Staff> sortedStaffs;
	private StaffFacade staffFacade;

	public static String TEST_USER_ID;

	private Organization organization;
	private List<Organization> organizations;
	private OrganizationFacade organizationFacade;
	private String userId;
	private Integer organizationId;

	public void createStaff()
	{
		staff.setOrganization(getOrganizationFacade().getOrganizationByUserId(userId));
		getStaffFacade().createStaff(staff);
		closeDialog();
		displayInfoMessageToUser("Created with success!");
		loadStaffs();
		resetStaff();
	}

	public void deleteStaff()
	{
		getStaffFacade().deleteStaff(staff);
		closeDialog();
		displayInfoMessageToUser("Deleted with success!");
		loadStaffs();
		resetStaff();
	}

	public void updateStaff()
	{
		getStaffFacade().updateStaff(staff);
		closeDialog();
		displayInfoMessageToUser("Updated with success!");
		loadStaffs();
		resetStaff();
	}

	public void resetStaff()
	{
		staff = new Staff();
	}

	public List<Staff> getAllStaffs()
	{
		if (staffs == null)
		{
			loadStaffs();
		}
		return staffs;
	}

	public void loadStaffs()
	{
		staffs = getStaffFacade().listAll();
	}

	public StaffFacade getStaffFacade()
	{
		if (staffFacade == null)
		{
			staffFacade = new StaffFacade();
		}
		return staffFacade;
	}

	public List<Staff> getSortedStaffList()
	{
		if (sortedStaffs == null)
		{
			loadSortedStaffList();
		}
		return sortedStaffs;
	}

	public void loadSortedStaffList()
	{
		Organization org = getOrganizationFacade().getOrganizationByUserId(StaffMB.TEST_USER_ID);
		Integer id = org.getId();

		setOrganizationId(id);
		sortedStaffs = getStaffFacade().listSortedStaffs(getOrganizationId());
	}

	public Staff getStaff()
	{
		if (staff == null)
		{
			staff = new Staff();
		}
		return staff;
	}

	public void setStaff(Staff staff)
	{
		this.staff = staff;
	}

	public Organization getOrganization()
	{
		if (organization == null)
		{
			organization = new Organization();
		}
		return organization;
	}

	public void setOrganization(Organization organization)
	{
		this.organization = organization;
	}

	public List<Organization> getOrganizations()
	{
		if (organizations == null)
		{
			loadOrganizations();
		}
		return organizations;
	}

	public void loadOrganizations()
	{
		organizations = getOrganizationFacade().listAll();
	}

	public OrganizationFacade getOrganizationFacade()
	{
		if (organizationFacade == null)
		{
			organizationFacade = new OrganizationFacade();
		}
		return organizationFacade;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public Integer getOrganizationId()
	{
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId)
	{
		this.organizationId = organizationId;
	}

	public String attr()
	{
		// helper.setUserId(getUserId());
		StaffMB.TEST_USER_ID = getUserId();
		return "/pages/protected/defaultUser/staff/staff.xhtml";
	}
}
