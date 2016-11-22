package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.model.Organization;

/**
 * 
 * @author Mickey
 * extends GenericDAO 
 */
public class OrganizationDAO extends GenericDAO<Organization>
{

	private static final long serialVersionUID = 1L; // required by Serializable

	public OrganizationDAO()
	{
		super(Organization.class);
	}

	/**
	 * performs delete operation on Organization
	 * 
	 * @param organization
	 * 
	 */
	public void delete(Organization organization)
	{
		super.delete(organization.getId(), Organization.class);
	}

	/**
	 * 
	 * @param User`s Id
	 * @return Organization object if userId does not exist  return empty
	 */
	public Organization findOrganizationByUserId(String userId)
	{
		Integer userIdd = Integer.parseInt(userId);
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userIdd);
		return super.findOneResult(Organization.FIND_ORGANIZATION_BY_USER_ID, params);
	}
}
