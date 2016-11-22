package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.StaffDAO;
import com.model.Staff;

/**
 * 
 * @author Mickey
 *
 */
public class StaffFacade implements Serializable
{
	private static final long serialVersionUID = 1L; // required by Serializable
	private StaffDAO staffDAO = new StaffDAO();

	public void createStaff(Staff staff)
	{
		staffDAO.beginTransaction();
		staffDAO.save(staff);
		staffDAO.commitAndCloseTransaction();
	}

	public List<Staff> listAll()
	{
		staffDAO.beginTransaction();
		List<Staff> result = staffDAO.findAll();
		staffDAO.closeTransaction();
		return result;
	}

	public void updateStaff(Staff staff)
	{
		staffDAO.beginTransaction();
		Staff staffToPersist = staffDAO.find(staff.getId());
		staffToPersist.setBankRekvezit(staff.getBankRekvezit());
		staffToPersist.setEmail(staff.getEmail());
		staffToPersist.setHomeAddress(staff.getHomeAddress());
		staffToPersist.setHomePhone(staff.getHomePhone());
		staffToPersist.setMobilePhone(staff.getMobilePhone());
		staffToPersist.setName(staff.getName());
		staffToPersist.setOrganization(staff.getOrganization());
		staffToPersist.setPosition(staff.getPosition());
		staffToPersist.setWebsite(staff.getWebsite());
		staffToPersist.setWorkingPhone(staff.getWorkingPhone());
		staffDAO.update(staffToPersist);
		staffDAO.commitAndCloseTransaction();
	}

	/**
	 * filter staffs by organization
	 * 
	 * @param organizationId
	 *            assumes organizationId is not null
	 * @return Staff list if query did not find anything return empty list
	 */
	public List<Staff> listSortedStaffs(Integer organizationId)
	{
		staffDAO.beginTransaction();
		List<Staff> result = staffDAO.getSortedStaffList(organizationId);
		staffDAO.closeTransaction();
		return result;
	}

	public void deleteStaff(Staff staff)
	{
		staffDAO.beginTransaction();
		Staff staffRefference = staffDAO.findReferenceOnly(staff.getId());
		staffDAO.delete(staffRefference);
		staffDAO.commitAndCloseTransaction();
	}
}
