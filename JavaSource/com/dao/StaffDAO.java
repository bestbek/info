package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Staff;

/**
 * 
 * @author Mickey
 *
 */
public class StaffDAO extends GenericDAO<Staff>
{
	private static final long serialVersionUID = 1L; // required by Serializable

	public StaffDAO()
	{
		super(Staff.class);
	}

	/**
	 * performs delete operation on Staff
	 * 
	 * @param staff
	 */
	public void delete(Staff staff)
	{
		super.delete(staff.getId(), Staff.class);
	}

	/**
	 * filter staff by organizationId
	 * 
	 * @param organizationId
	 *            assumes that organization id is not null
	 * @return sorted staff List if not found then empty List
	 * @see GenericDAO
	 */
	public List<Staff> getSortedStaffList(Integer organizationId)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("organizationId", organizationId);
		return super.findSortedResult(Staff.FIND_SORTED_STAFF_LIST, parameters); // Staff.FIND_SORTED_STAFF_LIST is a named query
	}

}
