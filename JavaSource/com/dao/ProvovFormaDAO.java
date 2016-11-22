package com.dao;

import com.model.ProvovForma;

/**
 * 
 * @author Mickey 
 * extends GenericDAO
 */
public class ProvovFormaDAO extends GenericDAO<ProvovForma>
{

	private static final long serialVersionUID = 1L; // required by Serializable

	public ProvovFormaDAO()
	{
		super(ProvovForma.class);
	}

	/**
	 * performs delete operation on Organization
	 * 
	 * @param organization
	 * 
	 */
	public void delete(ProvovForma provovForma)
	{
		super.delete(provovForma.getId(), ProvovForma.class);
	}
}
