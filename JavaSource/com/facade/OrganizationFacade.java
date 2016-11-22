package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.OrganizationDAO;
import com.model.Organization;

/**
 * 
 * @author Mickey
 *
 */
public class OrganizationFacade implements Serializable
{
	private static final long serialVersionUID = 1L; // required by Serializable

	private OrganizationDAO orgnizationDAO = new OrganizationDAO();

	public void createOrganization(Organization organization)
	{
		orgnizationDAO.beginTransaction();
		orgnizationDAO.save(organization);
		orgnizationDAO.commitAndCloseTransaction();
	}

	public List<Organization> listAll()
	{
		orgnizationDAO.beginTransaction();
		List<Organization> result = orgnizationDAO.findAll();
		orgnizationDAO.closeTransaction();
		return result;
	}

	public void deleteOrganization(Organization organization)
	{
		orgnizationDAO.beginTransaction();
		Organization organizationRef = orgnizationDAO.findReferenceOnly(organization.getId());
		orgnizationDAO.delete(organizationRef);
		orgnizationDAO.commitAndCloseTransaction();
	}

	public Organization getOrganization(int organizationId)
	{
		orgnizationDAO.beginTransaction();
		Organization organ = orgnizationDAO.find(organizationId);
		orgnizationDAO.closeTransaction();
		return organ;
	}

	/**
	 * filter organization by userId
	 * @param userId
	 * @return Organization 
	 */
	public Organization getOrganizationByUserId(String userId)
	{
		orgnizationDAO.beginTransaction();
		Organization organization = orgnizationDAO.findOrganizationByUserId(userId);
		orgnizationDAO.closeTransaction();
		return organization;
	}
}
